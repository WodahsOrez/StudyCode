package pattern.factory.family;

/**
 * @Description  美国家庭工厂
 * @author  WodahsOrez
 * @date 2018年6月5日 上午8:53:14 
 *  
 */
public class AmericanFamilyFactory extends FamilyFactory {

    /**  
     * @Description  创建美国父亲
     */
    @Override
    public Father createFather() {
        return new AmericanFather();
    }

    /**  
     * @Description  创建美国母亲
     */
    @Override
    public Mother createMother() {
        return new AmericanMother();
    }

}
