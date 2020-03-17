package com.ssm.entity;

public class UserInfo {

    //创建用户信息属性

    private Integer id;

    private String loginName;

    private String userName;

    private String passWord;

    private String Email;

    private String phone;

    //重写toString()
    @Override
    public String toString(){
        return "用户: " + " id: " + id + " 登录名: " + loginName + " 用户名: " + userName + " 邮箱: " + Email + " 电话: " + phone;
    }

    public UserInfo(){
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
