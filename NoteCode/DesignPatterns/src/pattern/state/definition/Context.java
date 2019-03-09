package pattern.state.definition;

/**
 * @Description  具体环境类
 * @author  WodahsOrez
 * @date 2018年7月9日 上午8:41:55 
 *  
 */
public class Context {
    /** 状态1 */
    public static final AbstractState STATE1 = new ConcreteState1();
    /** 状态2 */
    public static final AbstractState STATE2 = new ConcreteState2();
    /** 当前状态 */
    private AbstractState CurrentState;
    
    /**  
     * @Description  获得当前状态
     * @return   
     */
    public AbstractState getCurrentState() {
        return CurrentState;
    }
    
    /**  
     * @Description  设置当前状态
     * @param currentState   
     */
    public void setCurrentState(AbstractState currentState) {
        this.CurrentState = currentState;
        this.CurrentState.setContext(this);
    }
    
    /**  
     * @Description  委托执行行为1
     */
    public void handle1() {
        System.out.println("context:委托执行行为1");
        this.CurrentState.handle1();
    }
    
    /**  
     * @Description  委托执行行为2
     */
    public void handle2() {
        System.out.println("context:委托执行行为2");
        this.CurrentState.handle2();
    }
}
