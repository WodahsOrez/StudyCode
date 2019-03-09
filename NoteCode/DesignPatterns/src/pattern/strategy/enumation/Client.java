package pattern.strategy.enumation;

public class Client {
    public static void main(String[] args) {
        int result = Calculator.ADD.exec(3, 5);
        System.out.println("3 + 5 = "+result);
        result = Calculator.SUB.exec(3, 5);
        System.out.println("3 + 5 = "+result);
    }

}
