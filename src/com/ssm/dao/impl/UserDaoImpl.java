package com.ssm.dao.impl;

import com.ssm.dao.UserDao;
import com.ssm.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    //判断用户是否存在
    public boolean userExits(String loginName){

        //编写sql查询语句
        String sql = "select * from userInfo where loginName = ?";

        //创建一个BeanPropertyRowMapper对象，将结果集通过java反射机制映射到对象中
        BeanPropertyRowMapper<UserInfo> rowMapper = new BeanPropertyRowMapper<>(UserInfo.class);

        //创建一个list对象来保存查询到的结果集
        List<UserInfo> list = this.jdbcTemplate.query(sql, rowMapper, loginName);

        if (list.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    //注册用户方法
    public int register(UserInfo userInfo) {

        //判断用户是否存在,调用工具类中的方法来进行判断
//        Until until = new Until();
//
//        List<UserInfo> list = until.userExits();

        //执行插入sql
        String sql = "insert into userInfo(loginName, userName, passWord, Email, phone) values(?, ?, ?, ?, ?)";

        //使用数组来存储sql中的参数
        Object[] parmars = new  Object[]{userInfo.getLoginName(), userInfo.getUserName(),
                userInfo.getPassWord(), userInfo.getEmail(), userInfo.getPhone()};

        //执行update()方法
        int result = this.jdbcTemplate.update(sql, parmars);

        return result;

    }

    @Override
    //用户登录
    public List<UserInfo> login(String loginName, String passWord) {

        //定义查询sql语句
        String sql = "select * from userInfo where loginName = ? and passWord = ?";

        //创建一个新的BeanPropertyRowMapper对象，将结果集通过java反射机制映射到对象中
        BeanPropertyRowMapper<UserInfo> rowMapper = new BeanPropertyRowMapper<>(UserInfo.class);

        //将参数绑定到sql语句中并返回查询结果集
        return this.jdbcTemplate.query(sql, rowMapper, loginName, passWord);

    }

    @Override
    //更新用户信息
    public int updateUserName(UserInfo userInfo) {

        //执行更新语句
        String sql = "update userInfo set userName = ? where loginName = ?";

        //定义一个数组来保存sql语句中的参数
        Object[] parnars = new Object[]{userInfo.getUserName(), userInfo.getLoginName()};

        //执行update()方法
        int result = this.jdbcTemplate.update(sql, parnars);

        //返回执行结果条数
        return result;
    }

    @Override
    //更新密码
    public int updatePassword(UserInfo userInfo) {

        //定义sql更新语句
        String sql = "update userInfo set passWord = ? where loginName = ?";

        //使用数组来保存sql语句中的参数
        Object[] parmars = new Object[]{userInfo.getPassWord(), userInfo.getLoginName()};

        //执行jdbcTemplate中的update()方法
        int result = this.jdbcTemplate.update(sql, parmars);

        return result;
    }

    @Override
    //删除用户
    public int deleteUser(int id) {

        //定义sql语句
        String sql = "delete from userInfo where id = ?";

        //执行update()方法
        int result = this.jdbcTemplate.update(sql,id);

        //返回执行结果
        return result;
    }

    @Override
    //查询所有用户
    public List<UserInfo> queryAllUser() {

        //定义查询sql
        String sql = "select * from userInfo";

        //定义一个BeanPropertyRowMapper对象，将查询结果通过java反射机制映射到对象中
        BeanPropertyRowMapper<UserInfo> rowMapper = new BeanPropertyRowMapper<>(UserInfo.class);

        //返回List对象的结果集
        return this.jdbcTemplate.query(sql, rowMapper);
    }
}
