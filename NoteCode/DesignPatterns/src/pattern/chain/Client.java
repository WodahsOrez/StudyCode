package pattern.chain;

public class Client {
    public static void main(String[] args) {
        AbstractHandler handler1 = new ConcreteHandler1();
        AbstractHandler handler2 = new ConcreteHandler2();
        AbstractHandler handler3 = new ConcreteHandler3();
        // 设置链中的顺序1-->2-->3
        handler1.setNext(handler2);
        handler2.setNext(handler3);
        Response response = handler1.handleMessage(new Request());
    }
}
