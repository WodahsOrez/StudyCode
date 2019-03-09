package pattern.bridge;

/**
 * @Description  抽象化角色
 * @author  WodahsOrez
 * @date 2018年7月10日 下午1:12:01 
 *  
 */
public abstract class Abstraction {
    /** 对实现化角色的引用 */
    private Implementor imp;
    
    /**
     * @Description  设置实现化角色
     * @param imp  实现化角色
     */
    public Abstraction(Implementor imp) {
        this.imp = imp;
    }
    
    /**  
     * @Description  自身行为和属性
     */
    public void request() {
        this.imp.doSomething();
    }
    
    public Implementor getImp() {
        return this.imp;
    }
}
