package pattern.command;

public class Client {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        AbstractCommand command = new ConcreteCommand1();
        invoker.setCommand(command);
        invoker.action();
    }
}
