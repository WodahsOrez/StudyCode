package pattern.state.elevator;

/**
 * @Description  具体环境类
 * @author  WodahsOrez
 * @date 2018年7月9日 上午9:51:34 
 *  
 */
public class Context {
    /** 电梯开启状态 */
    public static final OpenState OPEN_STATE = new OpenState();
    /** 电梯关闭状态 */
    public static final CloseState CLOSE_STATE = new CloseState();
    /** 电梯运行状态 */
    public static final RunState RUN_STATE = new RunState();
    /** 电梯停止状态 */
    public static final StopState STOP_STATE = new StopState();
    
    /** 当前电梯状态 */
    private AbstractLiftState liftState;
    
    /**  
     * @Description  获得当前电梯状态
     */
    public AbstractLiftState getLiftState() {
        return liftState;
    }
    
    /**  
     * @Description  设置当前电梯状态
     */
    public void setLiftState(AbstractLiftState liftState) {
        this.liftState = liftState;
        this.liftState.setContext(this);
    }
    
    /**  
     * @Description  委托state执行开门动作
     */
    public void open() {
        this.liftState.open();
    }
    
    /**  
     * @Description  委托state执行关门动作
     */
    public void close() {
        this.liftState.close();
    }
    
    /**  
     * @Description  委托state执行升降动作
     */
    public void run() {
        this.liftState.run();
    }
    
    /**  
     * @Description  委托state执行停止动作
     */
    public void stop() {
        this.liftState.stop();
    }
}
