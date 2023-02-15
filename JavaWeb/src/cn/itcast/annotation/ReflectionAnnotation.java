package cn.itcast.annotation;

import java.lang.reflect.Method;

@Pro(className = "cn.itcast.domain.Person",methodName = "eat")
public class ReflectionAnnotation {
    public static void main(String[] args) throws Exception {
        //1.解析注解
        //1.1获取该类的字节码文件对象
        Class<ReflectionAnnotation> reflectTestClass = ReflectionAnnotation.class;
        //2.获取上边的注解对象
        Pro an = reflectTestClass.getAnnotation(Pro.class);
        //其实就是在内存中生成了一个该注解接口的子类实现对象
        /*
        public class ProImpl implements Pro{
            public String className(){
                return "cn.itcast.annotation.Demo1";
            }
            public String methodName(){
                return "show";
            }

        }
        */
        //3.调用注解对象中定义的抽象方法，获取返回值
        String className = an.className();
        String methodName = an.methodName();

        //4.执行
        Class cls = Class.forName(className);
        Object obj = cls.newInstance();
        Method method = cls.getMethod(methodName);
        method.invoke(obj);
    }
}
