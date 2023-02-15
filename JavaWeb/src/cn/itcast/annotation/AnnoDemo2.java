package cn.itcast.annotation;

import java.lang.annotation.Retention;

// 如果注解只有一个属性vale，则可以直接("xxx")，省略value
@MyAnno(name = "ikun",age = 20,gender = 1,hobbies = {"唱","跳","rap"})
public class AnnoDemo2 {

}
