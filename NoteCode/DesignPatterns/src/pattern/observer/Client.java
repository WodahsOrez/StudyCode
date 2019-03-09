package pattern.observer;

public class Client {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        Observer o = new ConcreteObserver();
        subject.addObserver(o);
        subject.doSomething();
    }
}
