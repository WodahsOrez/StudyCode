package pattern.visitor;

/**
 * @Description  具体元素类
 * @author  WodahsOrez
 * @date 2018年7月6日 上午7:54:22 
 *  
 */
public class ConcreteElement1 extends AbstractElement {
    /**  
     * @Description  业务逻辑方法
     */
    public void doSomething() {
        System.out.println("Element2业务逻辑");
    }
    
    /**  
     * @Description  访问者访问方法
     * @param visitor   允许哪个访问者
     */
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
