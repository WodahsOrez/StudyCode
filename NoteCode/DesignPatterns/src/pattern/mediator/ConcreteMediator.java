package pattern.mediator;

public class ConcreteMediator extends AbstractMediator {

    /**  
     * @Description  同事类之间的交互逻辑
     */
    @Override
    public void doSomething1() {
        // 通过c1,c2实现同事类之间的交互
        super.c1.selfMethod();
        super.c2.selfMethod();
    }

    /**  
     * @Description  同事类之间的交互逻辑
     */
    @Override
    public void doSomething2() {
        super.c1.selfMethod();
        super.c2.selfMethod();
    }

}
