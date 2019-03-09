package pattern.mediator;

/**
 * @Description  同事抽象类
 * @author  WodahsOrez
 * @date 2018年6月6日 上午9:08:02 
 *  
 */
public abstract class AbstractColleague {
    /** 同事类必须有中介者 */
    protected AbstractMediator mediator;
    
    /**
     * @Description  通过构造函数注入中介者 
     * @param mediator  中介者对象
     */
    public AbstractColleague(AbstractMediator mediator) {
        this.mediator = mediator;
    }
}
