package pattern.flyweight.definition;

/**
 * @Description  抽象享元类
 * @author  WodahsOrez
 * @date 2018年7月10日 上午10:37:45 
 *  
 */
public abstract class AbstractFlyweight {
    /** 内部状态 */
    private String intrinsic;
    /** 外部状态 */
    protected final String EXTRINSIC;
    
    /**
     * @Description  设置外部状态
     * @param EXTRINSIC  外部状态
     */
    public AbstractFlyweight(String EXTRINSIC) {
        this.EXTRINSIC = EXTRINSIC;
    }
    
    /**  
     * @Description  业务逻辑
     */
    public abstract void operate();
    
    public String getIntrinsic() {
        return intrinsic;
    }
    
    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }
}
