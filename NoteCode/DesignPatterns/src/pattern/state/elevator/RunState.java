package pattern.state.elevator;

/**
 * @Description  运行状态
 * @author  WodahsOrez
 * @date 2018年7月9日 上午10:02:46 
 *  
 */
public class RunState extends AbstractLiftState {
    /**  
     * @Description  不能开门
     */
    @Override
    public void open() {
        System.out.println("RunState:不能开门");
    }

    /**  
     * @Description  关闭电梯门    
     */
    @Override
    public void close() {
        System.out.println("RunState:已经关闭电梯门");
    }

    /**  
     * @Description  执行升降操作
     */
    @Override
    public void run() {
        System.out.println("RunState:执行升降操作");
    }

    /**  
     * @Description  转为停止状态
     */
    @Override
    public void stop() {
        System.out.println("RunState:转为停止状态");
        super.context.setLiftState(Context.STOP_STATE);
        super.context.getLiftState().stop();
    }
}
