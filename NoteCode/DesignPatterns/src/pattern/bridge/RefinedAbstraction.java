package pattern.bridge;

/**
 * @Description  修正抽象化角色
 * @author  WodahsOrez
 * @date 2018年7月10日 下午1:13:41 
 *  
 */
public class RefinedAbstraction extends Abstraction {
    /**
     * @Description  覆写构造函数
     */
    public RefinedAbstraction(Implementor imp) {
        super(imp);
    }

    /**  
     * @Description  修正父类行为
     */
    @Override
    public void request() {
        super.request();
        super.getImp().doAnything();
    }
}
