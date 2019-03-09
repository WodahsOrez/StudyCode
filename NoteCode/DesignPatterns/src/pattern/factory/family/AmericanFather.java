package pattern.factory.family;

/**
 * @Description  美国父亲
 * @author  WodahsOrez
 * @date 2018年6月5日 上午8:45:45 
 *  
 */
public class AmericanFather implements Father {

    /**  
     * @Description  美国父亲自我介绍  
     */
    @Override
    public void say() {
        System.out.println("I'm an American Father.");
    }

}
