package pattern.state.definition;

/**
 * @Description  抽象状态类
 * @author  WodahsOrez
 * @date 2018年7月9日 上午8:35:58 
 *  
 */
public abstract class AbstractState {
    /** 定义一个环境角色 */
    protected Context context;
    
    /**  
     * @Description  设置环境角色
     */
    public void setContext(Context context) {
        this.context = context;
    }
    
    /**  
     * @Description  行为1
     */
    public abstract void handle1();

    /**  
     * @Description  行为2  
     */
    public abstract void handle2();
}
