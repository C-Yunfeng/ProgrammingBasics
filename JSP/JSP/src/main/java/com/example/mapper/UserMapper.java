package com.example.mapper;

import com.example.po.User;

/**
 * 用户接口类
 */
public interface UserMapper {
    public User queryUserByName(String userName);
}
