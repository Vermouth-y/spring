package com.test;

import com.ssm.dao.UserDao;
import com.ssm.entity.UserInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class queryAllUser {

    @Test
    public void queryAllUser() {

        //初始化spring容器并加载applishcationContext.xml配置
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applishcationContext.xml");

        //加载配置文件中的userDao实例
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");

        //使用list保存查询结果
        List<UserInfo> list = userDao.queryAllUser();

        for (UserInfo ui : list) {
            System.out.println(ui);
        }

    }
}