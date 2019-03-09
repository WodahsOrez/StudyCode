package pattern.state.elevator;

/**
 * @Description  停止状态
 * @author  WodahsOrez
 * @date 2018年7月9日 上午10:02:46 
 *  
 */
public class StopState extends AbstractLiftState {
    /**  
     * @Description  转为敞门状态
     */
    @Override
    public void open() {
        System.out.println("StopState:转为敞门状态");
        super.context.setLiftState(Context.OPEN_STATE);
        super.context.getLiftState().open();
    }

    /**  
     * @Description  门已经关了   
     */
    @Override
    public void close() {
        System.out.println("StopState:门已经关了");
    }

    /**  
     * @Description  转为运行状态
     */
    @Override
    public void run() {
        System.out.println("StopState:转为运行状态");
        super.context.setLiftState(Context.RUN_STATE);
        super.context.getLiftState().run();
    }

    /**  
     * @Description  执行停止操作
     */
    @Override
    public void stop() {
        System.out.println("StopState:停止电梯");
    }
}
