package com.official.nvclouds.controller;

import com.official.nvclouds.dto.VerifyCode;
import com.official.nvclouds.enums.SysEnum;
import com.official.nvclouds.exception.SysException;
import com.official.nvclouds.base.BaseResult;
import com.official.nvclouds.dto.OfficialUserNoteDto;
import com.official.nvclouds.service.IVerifyCodeGen;
import com.official.nvclouds.service.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/8 16:59
 * @Description:
 */
@Slf4j
//@CrossOrigin
@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private IVerifyCodeGen iVerifyCodeGen;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/test")
    public Object test(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        return session.getId();
    }

    @PostMapping("/commit")
    public BaseResult commitNote(@RequestBody OfficialUserNoteDto officialUserNoteDto, HttpServletRequest request){
        try {
            noteService.commitNote(officialUserNoteDto,request);
        } catch (SysException e ) {
            return BaseResult.builder().code(SysEnum.PARAMS_ERRO.getCode()).msg(e.getMsg()).data(null).build();
        } catch (IllegalArgumentException e){
            return BaseResult.builder().code(SysEnum.PARAMS_ERRO.getCode()).msg(e.getMessage()).data(null).build();
        }
        return  BaseResult.ok();
    }

    @GetMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        try {
            //设置长宽
            //VerifyCode verifyCode = iVerifyCodeGen.generate(80, 28);
            VerifyCode verifyCode = iVerifyCodeGen.generate(115, 40);
            String code = verifyCode.getCode();
            //log.info(code);
            //将VerifyCode绑定session
//            request.getSession().setAttribute("VerifyCode", code);
//            String sessionId = request.getSession().getId();
            //将VerifyCode存储到redis中
            //redisTemplate.opsForValue().set(new StringBuilder(sessionId).append("_").append(code).toString(), code, 10, TimeUnit.MINUTES);
            redisTemplate.opsForValue().set("VerifyCode", code, 10, TimeUnit.MINUTES);
            //设置响应头
            response.setHeader("Pragma", "no-cache");
            //设置响应头
            response.setHeader("Cache-Control", "no-cache");
            //在代理服务器端防止缓冲
            response.setDateHeader("Expires", 0);
            //设置响应内容类型
            response.setContentType("image/jpeg");
            response.getOutputStream().write(verifyCode.getImgBytes());
            response.getOutputStream().flush();
        } catch (IOException e) {
            throw new SysException("验证码发送异常");
        }
    }

}
