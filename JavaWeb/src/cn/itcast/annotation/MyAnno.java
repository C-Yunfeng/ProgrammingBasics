package cn.itcast.annotation;

// 注解里只能存基础数据类型/String/枚举/注解，即以上类型的数组.如不能写自己定义的类
public @interface MyAnno {
    // public abstract简写了
    String name();
    int age();
    int gender() default 1;
    String[] hobbies();
}
