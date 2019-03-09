package pattern.command;

/**
 * @Description  抽象接受者
 * @author  WodahsOrez
 * @date 2018年6月6日 上午9:41:36 
 *  
 */
public abstract class AbstractReceiver {
    /**  
     * @Description  定义每个接收者必须完成的业务  
     */
    public abstract void doSomething();
}
