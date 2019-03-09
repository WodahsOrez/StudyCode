package pattern.command;

/**
 * @Description  具体的命令类
 * @author  WodahsOrez
 * @date 2018年6月6日 上午9:49:34 
 *  
 */
public class ConcreteCommand2 extends AbstractCommand {
    /**
     * @Description  设置默认接收者
     */
    public ConcreteCommand2() {
        super(new ConcreteReceiver2());
    }
    /**
     * @Description  构造函数传递接收者
     * @param receiver  接收者对象
     */
    public ConcreteCommand2(AbstractReceiver receiver) {
        super(receiver);
    }
    
    /**  
     * @Description  每个命令类必须实现执行命令方法
     */
    @Override
    public void execute() {
        // 业务逻辑
        this.receiver.doSomething();
    }

}
