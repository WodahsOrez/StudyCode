package pattern.bridge;

/**
 * @Description  具体实现化角色
 * @author  WodahsOrez
 * @date 2018年7月10日 下午1:11:36 
 *  
 */
public class ConcreteImplementor1 implements Implementor {
    /**  
     * @Description  业务逻辑
     */
    @Override
    public void doSomething() {
        System.out.println("ConcreteImplementor1----doSomething");
    }

    /**  
     * @Description  业务逻辑
     */
    @Override
    public void doAnything() {
        System.out.println("ConcreteImplementor1----doAnything");
    }
}
