package cn.itcast.reflect;

import cn.itcast.domain.Person;
import cn.itcast.junit.Calculator;

// 反射的定义：将类的各个组成部分封装成其他对象
// 反射的作用：根据类名生成类，不用在代码里写new了。即通过传参创建对象/调用方法/属性，而非将类名/方法/属性硬写到代码中。示例见https://juejin.cn/post/7096671072661012510#heading-1
// 反射的应用：
// 1.确定不下来使用哪个类的时候，如开发一个通用工具类，为了达到通用性，传入的参数对象一般是无法限制的，这时候就需要用到反射。
// 2.编辑器的提示，允许在编码时就能获取类，而非运行时。编码->编译->编码，所以称反射。
// 反射的优点：允许程序创建和控制任何类的对象，无需提前硬编码目标类。而且可以不用导入包。
public class ReflectionDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 同一个字节码文件在一次运行过程中，只会被加载一次
        // 方法一：多用于配置文件，将类名定义在配置文件中。读取文件，加载类
        Class cls1 = Class.forName("cn.itcast.domain.Person");
        System.out.println(cls1);
        // 方法二：多用于参数多传递
        Class cls2 = Person.class;
        System.out.println(cls2);
        // 方法三：多用于对象获取字节码的方式
        Calculator c = new Calculator();
        Class cls3 = c.getClass();
        System.out.println(cls3);
    }
}
