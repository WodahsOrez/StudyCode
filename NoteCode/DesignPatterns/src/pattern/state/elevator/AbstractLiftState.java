package pattern.state.elevator;

/**
 * @Description  抽象电梯状态
 * @author  WodahsOrez
 * @date 2018年7月9日 上午9:34:56 
 *  
 */
public abstract class AbstractLiftState {
    /** 定义环境对象 */
    protected Context context;
    
    /**  
     * @Description  设置环境对象
     * @param context   
     */
    public void setContext(Context context) {
        this.context = context;
    }
    
    /**  
     * @Description  电梯开门
     */
    public abstract void open();
    /**  
     * @Description  电梯关门
     */
    public abstract void close();
    /**  
     * @Description  电梯升降
     */
    public abstract void run();
    /**  
     * @Description  电梯停止
     */
    public abstract void stop();
}
