package com.official.nvclouds.service.impl;

import com.official.nvclouds.exception.SysException;
import com.official.nvclouds.dto.OfficialUserNoteDto;
import com.official.nvclouds.mapper.OfficialUserNoteMapper;
import com.official.nvclouds.model.OfficialUserNote;
import com.official.nvclouds.service.NoteService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/8 17:04
 * @Description:
 */
@Service
public class NoteServiceImpl implements NoteService {

    private final static String CODE_KEY = "%s_official_code";

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private OfficialUserNoteMapper userNoteMapper;

    @Override
    public void commitNote(OfficialUserNoteDto officialUserNoteDto, HttpServletRequest request) {
        Assert.notNull(officialUserNoteDto.getName(),"姓名不能为空");
        Assert.notNull(officialUserNoteDto.getPhoneNum(),"联系方式不能为空");
        Assert.notNull(officialUserNoteDto.getEmail(),"邮件不能为空");
        Assert.notNull(officialUserNoteDto.getOrganization(),"组织不能为空");
        Assert.notNull(officialUserNoteDto.getCode(),"验证码不能为空");
        Assert.notNull(officialUserNoteDto.getNote(),"留言不能为空");
        String sessionId = request.getSession().getId();
        //redisTemplate.opsForValue().set(new StringBuilder(sessionId).append("_").append(code).toString(), code, 10, TimeUnit.MINUTES);
        //String code = redisTemplate.opsForValue().get(new StringBuilder(sessionId).append("_").append(officialUserNoteDto.getCode()).toString());
        String code = redisTemplate.opsForValue().get("VerifyCode");
        //String code = (String) request.getSession().getAttribute("VerifyCode");
        if (StringUtils.isBlank(code)) {
            throw new SysException("验证码错误");
        }else {
            if (!code.equalsIgnoreCase(officialUserNoteDto.getCode())) {
                throw new SysException("验证码错误");
            }
        }
        OfficialUserNote userNote = null;
        BeanUtils.copyProperties(officialUserNoteDto,userNote = new OfficialUserNote());
        userNote.setCreted(new Timestamp(System.currentTimeMillis()));
        userNoteMapper.insert(userNote);
    }
}
