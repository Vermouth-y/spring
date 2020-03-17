package com.test;

import com.ssm.dao.UserDao;
import com.ssm.entity.UserInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UpdatePassword {

    @Test
    public void updatePassword() {

        //初始化spring容器,并加载applishcationContext.xml配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applishcationContext.xml");

        //通过spring容器获取userDao实例
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");

        //实例化UserInfo对象并执行赋值并修改
        UserInfo userInfo = new UserInfo();

        //判断用户是否存在
        boolean flag = userDao.userExits("vermouth");

        if (flag) {
            //设置登录名条件过滤
            userInfo.setLoginName("vermouth");

            //密码修改
            userInfo.setPassWord("vermouth");

            //执行修改方法
            userDao.updatePassword(userInfo);

            System.out.println("密码修改成功");
        } else {
            System.out.println("该用户不存在");
        }
    }
}