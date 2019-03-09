package pattern.mediator;

/**
 * @Description  同事实现类
 * @author  WodahsOrez
 * @date 2018年6月6日 上午9:09:01 
 *  
 */
public class ConcreteColleague1 extends AbstractColleague {
    /**
     * @Description  构造函数注入中介者
     * @param mediator  中介者
     */
    public ConcreteColleague1(AbstractMediator mediator) {
        super(mediator);
    }
    
    /**  
     * @Description  自有方法
     */
    public void selfMethod() {
        // 自己的业务逻辑
    }
    
    /**  
     * @Description  依赖方法
     */
    public void depMethod() {
        // 处理自己的业务逻辑
        // 不能处理的,委托给中介者处理
        super.mediator.doSomething1();
    }
}
