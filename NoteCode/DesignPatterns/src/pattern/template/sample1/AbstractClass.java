package pattern.template.sample1;

/**
 * @Description  抽象模板类
 * @author  WodahsOrez
 * @date 2018年6月5日 上午9:08:14 
 *  
 */
public abstract class AbstractClass {
    /**  
     * @Description  基本方法 
     */
    protected abstract void doAnything();  
    /**  
     * @Description  基本方法
     */
    protected abstract void doSomething();  
    /**  
     * @Description  钩子方法,默认父类方法返回真
     * @return   true
     */
    protected boolean isDoSomething(){ 
        return true;
    }
    /**  
     * @Description  调用基本方法，完成相关的逻辑  
     */
    public final void templateMethod(){
        this.doAnything();
        if(this.isDoSomething())
            this.doSomething();
    }

}
