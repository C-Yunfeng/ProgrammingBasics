package com.example;

import com.example.mapper.UserMapper;
import com.example.po.User;
import com.example.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

public class UserTest {
    public static void main(String[] args) {
        SqlSession sqlSession = GetSqlSession.createSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryUserByName("admin");
        System.out.println(user);
    }
}
