package pattern.command;

/**
 * @Description  调用者类
 * @author  WodahsOrez
 * @date 2018年6月6日 上午9:51:40 
 *  
 */
public class Invoker {
    /** 需要执行的命令类 */
    private AbstractCommand command;
    
    /**  
     * @Description  设置命令类
     */
    public void setCommand(AbstractCommand command) {
       this.command = command; 
    }
    
    /**  
     * @Description  执行命令
     */
    public void action() {
        this.command.execute();
    }
}
