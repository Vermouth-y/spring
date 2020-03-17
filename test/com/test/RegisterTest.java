package com.test;

import com.ssm.dao.UserDao;
import com.ssm.entity.UserInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * className:RegisterTest
 * author:苦艾酒
 * type:小学生写代码
 */
public class RegisterTest {

    @Test
    public void register() {

        //初始化spring容器,加载applishcationContext.xml配置
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applishcationContext.xml");

        //通过spring容器获取userDao实例
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");

        //添加属性值
        String loginName = "vermouth";
        String passWord = "kagura";
        String userName = "神乐";
        String Email = "wang_lei@bjgoodwill.com";
        String phone = "17623317215";

        //判断用户是否存在
        boolean flag = userDao.userExits(loginName);

        if (flag) {
            System.out.println("用户已经存在");
        } else {
            //实例化UserInfo对象，并添加属性
            UserInfo userInfo = new UserInfo();
            userInfo.setLoginName(loginName);
            userInfo.setUserName(userName);
            userInfo.setEmail(Email);
            userInfo.setPhone(phone);
            userInfo.setPassWord(passWord);

            int result = userDao.register(userInfo);

            if (result > 0) {
                System.out.println("注册成功");
            } else {
                System.out.println("注册失败");
            }
        }

    }
}