package pattern.factory.family;

/**
 * @Description  美国母亲
 * @author  WodahsOrez
 * @date 2018年6月5日 上午8:47:55 
 *  
 */
public class AmericanMother implements Mother {

    /**  
     * @Description  美国母亲自我介绍    
     */
    @Override
    public void say() {
        System.out.println("I'm an American Mother.");
    }

}
