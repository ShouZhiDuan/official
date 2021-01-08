package com.official.nvclouds.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
public class OfficialUserNoteDto {
    private String name;
    private String email;
    private String phoneNum;
    private String organization;
    private String code;
    private String note;
}