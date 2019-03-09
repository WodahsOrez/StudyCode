package pattern.facade;

/**
 * @Description  门面对象
 * @author  WodahsOrez
 * @date 2018年6月19日 下午3:32:18 
 *  
 */
public class Facade {
    /** 被委托的子系统对象 */
    private ClassA a = new ClassA();
    private ClassB b = new ClassB();
    private ClassC c = new ClassC();
    
    /**  
     * @Description  提供给外部访问的方法
     */
    public void methodA() {
        this.a.doSomethingA();
    }
    
    public void methodB() {
        this.b.doSomethingB();
    }
    
    public void methodC() {
        this.c.doSomethingC();
    }
}
