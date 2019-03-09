package pattern.adpater;

public class Client {

    public static void main(String[] args) {
        // 类适配器使用
        Adapter1 adapter1 = new Adapter1();
        adapter1.doSomething();
        // 对象适配器使用
        Adaptee1 adaptee1 = new Adaptee1();
        Adaptee2 adaptee2 = new Adaptee2();
        Adapter2 adapter2 = new Adapter2(adaptee1, adaptee2);
        adapter2.request();
    }

}
