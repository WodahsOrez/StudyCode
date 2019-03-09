package pattern.factory.family;

public class Client {
    public static void main(String[] args) {
        FamilyFactory factory1 = new AmericanFamilyFactory();
        Father father1 = factory1.createFather();
        Mother mother1 = factory1.createMother();
        father1.say();
        mother1.say();
        FamilyFactory factory2 = new ChineseFamilyFactory();
        Father father2 = factory2.createFather();
        Mother mother2 = factory2.createMother();
        father2.say();
        mother2.say();
    }
}
