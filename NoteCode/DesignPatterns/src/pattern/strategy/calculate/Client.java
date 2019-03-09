package pattern.strategy.calculate;

public class Client {
    public static void main(String[] args) {
        Context context = new Context(new Add());
        int result = context.exec(7, 3);
        System.out.println("7 + 3 = "+result);
        context = new Context(new Sub());
        result = context.exec(5, 1);
        System.out.println("5 - 1 = "+result);
    }
}
