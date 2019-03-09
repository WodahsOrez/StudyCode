package pattern.flyweight.definition;

/**
 * @Description  具体享元类
 * @author  WodahsOrez
 * @date 2018年7月10日 上午10:32:03 
 *  
 */
public class ConcreteFlyweight2 extends AbstractFlyweight{
    /**
     * @Description  设置外部状态
     * @param EXTRINSIC  外部状态
     */
    public ConcreteFlyweight2(String EXTRINSIC) {
        super(EXTRINSIC);
    }
    
    /**  
     * @Description  具体业务逻辑
     */
    @Override
    public void operate() {
        System.out.println("业务逻辑");
    }
    
}
