package pattern.state.elevator;

/**
 * @Description  敞门状态
 * @author  WodahsOrez
 * @date 2018年7月9日 上午9:38:01 
 *  
 */
public class OpenState extends AbstractLiftState{

    /**  
     * @Description  打开电梯门
     */
    @Override
    public void open() {
        System.out.println("OpenState:打开电梯门");
    }

    /**  
     * @Description  转为关门状态
     */
    @Override
    public void close() {
        System.out.println("OpenState:转为关门状态");
        super.context.setLiftState(Context.CLOSE_STATE);
        super.context.getLiftState().close();
    }

    /**  
     * @Description  开门无法升降
     */
    @Override
    public void run() {
        System.out.println("OpenState:请先关门");
    }

    /**  
     * @Description  开门已经停止
     */
    @Override
    public void stop() {
        System.out.println("OpenState:已经停止了");
    }
    
}
