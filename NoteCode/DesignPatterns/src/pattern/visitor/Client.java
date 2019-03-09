package pattern.visitor;

public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            AbstractElement el= ObjectStructure.createElement();
            el.accept(new VisitorImpl());
        }
    }
}
