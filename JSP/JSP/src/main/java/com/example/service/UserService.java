package com.example.service;

import com.example.mapper.UserMapper;
import com.example.po.User;
import com.example.util.GetSqlSession;
import com.example.util.StringUtils;
import com.example.vo.MessageModel;
import org.apache.ibatis.session.SqlSession;

public class UserService {

    public MessageModel userLogin(String uname, String upwd) {
        MessageModel messageModel = new MessageModel();
        // 1.参数非空判断
        if(StringUtils.strIsEmpty(uname) || StringUtils.strIsEmpty(upwd)){
            // 若空,则返回消息对象
            messageModel.setStatus(0);
            messageModel.setMsg("用户名或密码不能为空");
            // 回显数据
            User user = new User();
            user.setUserName(uname);
            user.setUserPwd(upwd);
            messageModel.setObject(user);
            return messageModel;
        }
        // 2.调用dao方法,通过登陆名查询用户对象
        SqlSession sqlSession = GetSqlSession.createSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryUserByName(uname);

        // 3.判断用户对象是否为空
        if (user == null){
            // 若为空,则通过消息模型对象返回结果(设置状态/提示信息/回显数据)
            messageModel.setStatus(0);
            messageModel.setMsg("该用户不存在");
            messageModel.setObject(user) ;
            return messageModel;
        }

        // 4.匹配用户名及密码
        if (!upwd.equals(user.getUserPwd())){
            // 若不相等,则通过消息模型对象返回结果(设置状态/提示信息/回显数据)
            messageModel.setStatus(0);
            messageModel.setMsg("用户或密码错误");
            messageModel.setObject(user);
            return messageModel;
        }
        //   若相等,则登陆成功,将用户信息设置到session作用域中,重定向至首页
        messageModel.setObject(user);
        return messageModel;
    }
}
