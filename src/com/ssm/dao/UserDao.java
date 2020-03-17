package com.ssm.dao;

import com.ssm.entity.UserInfo;

import java.util.List;

public interface UserDao {

    //判断用户是否存在
    public boolean userExits(String loginName);

    //创建用户注册接口
    public int register(UserInfo userInfo);

    //创建用户登录接口
    public List<UserInfo> login(String loginName, String passWord);

    //创建修改个人信息接口(用户名)
    public int updateUserName(UserInfo userInfo);

    //创建修改密码接口
    public int updatePassword(UserInfo userInfo);

    //创建用户注销(删除)接口
    public int deleteUser(int id);

    //创建查询所有用户接口
    public List<UserInfo> queryAllUser();
}
