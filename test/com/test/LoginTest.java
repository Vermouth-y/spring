package com.test;

import com.ssm.dao.UserDao;
import com.ssm.entity.UserInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void login() {

        //初始化spring容器并加载applishcationContext.xml配置
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applishcationContext.xml");

        //通过spring容器获取userDao实例
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");

        //定义用户名及密码变量
        String loginName = "vermouth";
        String passWord = "vermouth";

        //用户判断
        if (userDao.userExits(loginName)){
            //使用list对象来保存查询出来的结果集
            List<UserInfo> list = userDao.login(loginName, passWord);
            //密码判断
            if (list.size() < 1){
                System.out.println("密码可能不正确");
            } else {
                for (UserInfo ui : list){
                    if (ui.getLoginName().equals(loginName) && ui.getPassWord().equals(passWord)){
                        System.out.println("登录成功");
                    }
                }
            }
        } else {
            System.out.println("用户不存在");
        }
    }
}