package pattern.state.elevator;

public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(new CloseState());
        context.open();
        context.close();
        context.run();
        context.stop();
        
    }
}
