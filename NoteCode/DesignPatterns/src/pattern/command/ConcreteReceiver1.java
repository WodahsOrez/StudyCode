package pattern.command;

/**
 * @Description  具体的接收者
 * @author  WodahsOrez
 * @date 2018年6月6日 上午9:44:00 
 *  
 */
public class ConcreteReceiver1 extends AbstractReceiver {
    /**  
     * @Description  每个接收者都必须完成的业务逻辑 
     */
    @Override
    public void doSomething() {
        // 业务逻辑处理
        System.out.println("receiver1 is doing Something");
    }
}
