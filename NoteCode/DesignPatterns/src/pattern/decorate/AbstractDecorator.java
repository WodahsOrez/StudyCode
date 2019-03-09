package pattern.decorate;

/**
 * @Description  抽象装饰类
 * @author  WodahsOrez
 * @date 2018年6月6日 下午2:14:52 
 *  
 */
public abstract class AbstractDecorator extends AbstractComponent {
    /** 被修饰者 */
    private AbstractComponent component = null;
    
    /**
     * @Description  通过构造函数传递被修饰者
     * @param component   
     */
    public AbstractDecorator(AbstractComponent component) {
        this.component = component;
    }
    
    /**  
     * @Description  委托被修饰者执行
     */
    @Override
    public void operate() {
        this.component.operate();
    }
}
