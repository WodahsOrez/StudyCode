package pattern.decorate;

/**
 * @Description  具体装饰类
 * @author  WodahsOrez
 * @date 2018年6月6日 下午2:11:50 
 *  
 */
public class ConcreteDecorator2 extends AbstractDecorator {
    /**
     * @Description  定义被修饰者
     */
    public ConcreteDecorator2(AbstractComponent component) {
        super(component);
    }
    
    private void method2() {
        System.out.println("method2 修饰");
    }

    /**  
     * @Description  重写父类方法
     */
    @Override
    public void operate() {
        super.operate();
        this.method2();
    }
    
    
}
