package pattern.mediator;

/**
 * @Description  中介者抽象类
 * @author  WodahsOrez
 * @date 2018年6月6日 上午9:12:11 
 *  
 */
public abstract class AbstractMediator {
    /** 同事类1 */
    protected ConcreteColleague1 c1;
    
    /** 同事类2 */
    protected ConcreteColleague2 c2;
    
    public ConcreteColleague1 getC1() {
        return c1;
    }
    
    public void setC1(ConcreteColleague1 c1) {
        this.c1 = c1;
    }
    
    public ConcreteColleague2 getC2() {
        return c2;
    }
    public void setC2(ConcreteColleague2 c2) {
        this.c2 = c2;
    }
    
    /**  
     * @Description  同事类之间的交互逻辑   
     */
    public abstract void doSomething1();
    
    /**  
     * @Description  同事类之间的交互逻辑
     */
    public abstract void doSomething2();
}
