package cn.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.junit.jupiter.api.Test;

public class UserDaoTest {


    @Test
    public void testLogin(){
        User loginUser = new User();
        loginUser.setUsername("superbaby");
        loginUser.setPassword("123111");


        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

        System.out.println(user);
    }
}
