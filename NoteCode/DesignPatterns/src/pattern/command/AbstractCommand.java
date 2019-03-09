package pattern.command;

/**
 * @Description  命令抽象类
 * @author  WodahsOrez
 * @date 2018年6月6日 上午9:40:09 
 *  
 */
public abstract class AbstractCommand {
    /** 定义一个子类全局共享变量 */
    protected final AbstractReceiver receiver;
    
    /**
     * @Description  实现类必须传入一个接收者
     */
    public AbstractCommand(AbstractReceiver receiver) {
        this.receiver = receiver;
    }
    /**  
     * @Description  每个命令类都必须有一个执行命令的方法  
     */
    public abstract void execute();
}
