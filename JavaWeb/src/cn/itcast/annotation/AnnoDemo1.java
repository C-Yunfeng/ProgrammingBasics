package cn.itcast.annotation;

public class AnnoDemo1 {

    @Deprecated
    public void show(){
        System.out.println("show...");
    }

    public void test() {
        show();
    }
}
