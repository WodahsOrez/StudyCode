package pattern.decorate;

public class Client {
    public static void main(String[] args) {
        AbstractComponent component = new ConcreteComponent();
        component = new ConcreteDecorator1(component);
        component = new ConcreteDecorator2(component);
        component.operate();
    }
}
