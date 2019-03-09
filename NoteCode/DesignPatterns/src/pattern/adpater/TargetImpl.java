package pattern.adpater;

/**
 * @Description  目标角色实现类
 * @author  WodahsOrez
 * @date 2018年6月7日 上午8:59:15 
 *  
 */
public class TargetImpl implements Target {

    /**  
     * @Description  实现接口的方法
     */
    @Override
    public void request() {
        System.out.println("if you need any help, pls call me!");
    }

}
