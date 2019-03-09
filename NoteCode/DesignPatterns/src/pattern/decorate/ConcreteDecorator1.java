package pattern.decorate;

/**
 * @Description  具体装饰类
 * @author  WodahsOrez
 * @date 2018年6月6日 下午2:11:50 
 *  
 */
public class ConcreteDecorator1 extends AbstractDecorator {
    /**
     * @Description  定义被修饰者
     */
    public ConcreteDecorator1(AbstractComponent component) {
        super(component);
    }
    
    private void method1() {
        System.out.println("method1 修饰");
    }

    /**  
     * @Description  重写父类方法
     */
    @Override
    public void operate() {
        this.method1();
        super.operate();
    }
}
