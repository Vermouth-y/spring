package com.test;

import com.ssm.dao.UserDao;
import com.ssm.entity.UserInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class updateUserName {

    @Test
    public void updateUserName() {

        //初始化spring容器并加载applishcationContext.xml配置
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applishcationContext.xml");

        //通过spring容器获取userDao实例
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");

        //判断用户是否存在
        boolean flag = userDao.userExits("vermouth");

        //实例化实体类并进行修改
        UserInfo userInfo = new UserInfo();

        if (flag) {

            userInfo.setUserName("贝尔摩德");
            //update语句中有where条件，需要设置登录名参数
            userInfo.setLoginName("vermouth");
            userDao.updateUserName(userInfo);
            System.out.println("修改成功");
        } else {
            System.out.println("该用户不存在,不能进行修改");
        }

    }
}