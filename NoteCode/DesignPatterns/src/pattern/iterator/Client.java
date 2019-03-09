package pattern.iterator;

public class Client {
    public static void main(String[] args) {
        Aggregate agg = new ConcreteAggregate();
        
        agg.add("abc");
        agg.add("aaa");
        agg.add("1234");
        
        Iterator iterator = agg.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
