package pattern.state.definition;

/**
 * @Description  具体状态类
 * @author  WodahsOrez
 * @date 2018年7月9日 上午8:38:46 
 *  
 */
public class ConcreteState1 extends AbstractState {
    /**  
     * @Description  行为1
     */
    @Override
    public void handle1() {
        System.out.println("state1:状态1必须处理的逻辑");
    }

    /**  
     * @Description  行为2,转为状态2,由状态2执行行为2
     */
    @Override
    public void handle2() {
        System.out.println("state1:转为状态2");
        super.context.setCurrentState(Context.STATE2);
        System.out.println("state1:委托context执行行为2");
        super.context.handle2();
    }
}
