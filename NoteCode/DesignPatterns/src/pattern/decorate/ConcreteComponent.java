package pattern.decorate;

/**
 * @Description  具体构件
 * @author  WodahsOrez
 * @date 2018年6月6日 下午2:01:20 
 *  
 */
public class ConcreteComponent extends AbstractComponent {

    /**  
     * @Description  具体实现    
     */
    @Override
    public void operate() {
        System.out.println("do Something");
    }

}
