package com.official.nvclouds.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "official_user_note")
public class OfficialUserNote {
    @Id
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 联系方式
     */
    @Column(name = "phone_num")
    private String phoneNum;

    /**
     * 所属公司、机构、组织
     */
    private String organization;

    /**
     * 咨询时间
     */
    private Date creted;

    /**
     * 咨询内容
     */
    private String note;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取联系方式
     *
     * @return phone_num - 联系方式
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * 设置联系方式
     *
     * @param phoneNum 联系方式
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    /**
     * 获取所属公司、机构、组织
     *
     * @return organization - 所属公司、机构、组织
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * 设置所属公司、机构、组织
     *
     * @param organization 所属公司、机构、组织
     */
    public void setOrganization(String organization) {
        this.organization = organization == null ? null : organization.trim();
    }

    /**
     * 获取咨询时间
     *
     * @return creted - 咨询时间
     */
    public Date getCreted() {
        return creted;
    }

    /**
     * 设置咨询时间
     *
     * @param creted 咨询时间
     */
    public void setCreted(Date creted) {
        this.creted = creted;
    }

    /**
     * 获取咨询内容
     *
     * @return note - 咨询内容
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置咨询内容
     *
     * @param note 咨询内容
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}