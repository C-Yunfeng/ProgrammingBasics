package com.example.util;

/**
 * 字符串工具类
 */
public class StringUtils {
    /**
     * 判断字符串是否为空
     *   若空,返回true;否则返回false
     * @param str
     * @return
     */
    public static boolean strIsEmpty(String str){
        if (str == null || "".equals(str.trim())){
            return true;
        }
        return false;
    }
}
