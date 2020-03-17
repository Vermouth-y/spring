package com.test;

import com.ssm.dao.UserDao;
import com.ssm.entity.UserInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class deleteUser {

    @Test
    public void deleteUser() {

        //初始化spring容器并加载applishcationContext.xml配置
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applishcationContext.xml");

        //通过spring容器获取userDao实例
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");

        //执行update()方法
        userDao.deleteUser(3);

        System.out.println("删除成功");

    }
}