package com.example.po;

/**
 * User实体类
 */
public class User {
    private Integer userId;
    private String userName;
    private String userPwd;
    private Integer userAge;

    public User() {
    }

    public User(Integer userId, String userName, String userPwd) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public User(Integer userId, String userName, String userPwd, Integer userAge) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userAge = userAge;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
