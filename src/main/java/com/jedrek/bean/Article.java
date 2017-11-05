package com.jedrek.bean;

import java.sql.Timestamp;
import java.util.Date;

public class Article {
    private Integer articleId;  //公文ID
    private String content;     //公文内容
    private String title;       // 公文标题
    private Timestamp submitDate; //提交日期
    private String writer;    //作者
    private String institution; //作者机构
    private Integer departmentPass; //部门审批状态　0驳回　１通过
    private String departmentReview; //部门审批意见
    private String departmentPassUser; //部门审批人
    private Integer unitPass;    //单位审批状态　0驳回　１通过
    private String unitReview;   //单位审批意见
    private Integer unitPassUser; //单位审批人
    private Integer secret;  //公开级别

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Timestamp submitDate) {
        this.submitDate = submitDate;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Integer getDepartmentPass() {
        return departmentPass;
    }

    public void setDepartmentPass(Integer departmentPass) {
        this.departmentPass = departmentPass;
    }

    public String getDepartmentReview() {
        return departmentReview;
    }

    public void setDepartmentReview(String departmentReview) {
        this.departmentReview = departmentReview;
    }

    public String getDepartmentPassUser() {
        return departmentPassUser;
    }

    public void setDepartmentPassUser(String departmentPassUser) {
        this.departmentPassUser = departmentPassUser;
    }

    public Integer getUnitPass() {
        return unitPass;
    }

    public void setUnitPass(Integer unitPass) {
        this.unitPass = unitPass;
    }

    public String getUnitReview() {
        return unitReview;
    }

    public void setUnitReview(String unitReview) {
        this.unitReview = unitReview;
    }

    public Integer getUnitPassUser() {
        return unitPassUser;
    }

    public void setUnitPassUser(Integer unitPassUserId) {
        this.unitPassUser = unitPassUserId;
    }

    public Integer getSecret() {
        return secret;
    }

    public void setSecret(Integer secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", submitDate=" + submitDate +
                ", writer='" + writer + '\'' +
                ", institution='" + institution + '\'' +
                ", departmentPass=" + departmentPass +
                ", departmentReview='" + departmentReview + '\'' +
                ", departmentPassUserId='" + departmentPassUser + '\'' +
                ", unitPass=" + unitPass +
                ", unitReview='" + unitReview + '\'' +
                ", unitPassUserId=" + unitPassUser +
                ", secret=" + secret +
                '}';
    }
}
