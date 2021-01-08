package com.official.nvclouds.service;

import com.official.nvclouds.dto.OfficialUserNoteDto;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/8 17:04
 * @Description:
 */
public interface NoteService {
    //保存用户留言
    void commitNote(OfficialUserNoteDto officialUserNoteDto, HttpServletRequest request);
}
