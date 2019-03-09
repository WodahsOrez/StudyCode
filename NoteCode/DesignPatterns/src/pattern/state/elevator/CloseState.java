package pattern.state.elevator;

/**
 * @Description  关门状态
 * @author  WodahsOrez
 * @date 2018年7月9日 上午10:02:46 
 *  
 */
public class CloseState extends AbstractLiftState {
    /**  
     * @Description  转为开门状态
     */
    @Override
    public void open() {
        System.out.println("CloseState:转为开门状态");
        super.context.setLiftState(Context.OPEN_STATE);
        super.context.getLiftState().open();
    }

    /**  
     * @Description  关闭电梯门    
     */
    @Override
    public void close() {
        System.out.println("CloseState:关闭电梯门");
    }

    /**  
     * @Description  转为运行状态
     */
    @Override
    public void run() {
        System.out.println("CloseState:转为运行状态");
        super.context.setLiftState(Context.RUN_STATE);
        super.context.getLiftState().run();
    }

    /**  
     * @Description  转为停止状态
     */
    @Override
    public void stop() {
        System.out.println("CloseState:转为停止状态");
        super.context.setLiftState(Context.STOP_STATE);
        super.context.getLiftState().stop();
    }
}
