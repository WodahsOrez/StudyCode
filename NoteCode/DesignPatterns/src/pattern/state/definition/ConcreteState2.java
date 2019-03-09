package pattern.state.definition;

/**
 * @Description  具体状态类
 * @author  WodahsOrez
 * @date 2018年7月9日 上午8:38:46 
 *  
 */
public class ConcreteState2 extends AbstractState {
    /**  
     * @Description  行为1,转为状态1,由状态1执行行为1
     */
    @Override
    public void handle1() {
        System.out.println("state2:转为状态1");
        super.context.setCurrentState(Context.STATE1);
        System.out.println("state2:委托context执行行为1");
        super.context.handle1();
    }

    /**  
     * @Description  行为2
     */
    @Override
    public void handle2() {
        System.out.println("state2:状态2必须处理的逻辑");
    }
}
