package com.jedrek.bean;

public class User {
    private Integer userId;    //用户ID
    private String username;  //用户名
    private String truename;  //用户真实姓名
    private String password; //用户密码
    private Integer degree; //用户级别　2普通职员 3部门负责人 4管理员 5单位领导

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", truename='" + truename + '\'' +
                ", password='" + password + '\'' +
                ", degree=" + degree +
                '}';
    }
}
