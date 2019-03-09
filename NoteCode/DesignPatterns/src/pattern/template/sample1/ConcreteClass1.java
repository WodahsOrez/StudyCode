package pattern.template.sample1;

/**
 * @Description  模板模式子类
 * @author  WodahsOrez
 * @date 2018年6月5日 上午9:10:29 
 *  
 */
public class ConcreteClass1 extends AbstractClass {
    /** 决定是否执行doSomething方法的标识 */
    private boolean isDoSth;
    
    /**  
     * @Description  定义子类特有的算法算法代码
     */
    @Override
    protected void doAnything() {
    }

    /**  
     * @Description  定义子类特有的算法代码
     */
    @Override
    protected void doSomething() {
    }
    
    /**  
     * @Description  设置isDoSth标识的方法
     * @param isDo  boolean值
     */
    protected void setDo(boolean isDo){
        this.isDoSth = isDo;
    }
    
    /**  
     * @Description  重写父类钩子方法
     * @return  设置好的isDoSth标识
     */
    protected boolean isDoSomething(){
        return isDoSth;
    }


}
