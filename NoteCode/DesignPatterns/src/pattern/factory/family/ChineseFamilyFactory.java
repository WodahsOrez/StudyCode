package pattern.factory.family;

/**
 * @Description  中国家庭工厂
 * @author  WodahsOrez
 * @date 2018年6月5日 上午8:53:14 
 *  
 */
public class ChineseFamilyFactory extends FamilyFactory {

    /**  
     * @Description  创建中国父亲
     */
    @Override
    public Father createFather() {
        return new ChineseFather();
    }

    /**  
     * @Description  创建中国母亲
     */
    @Override
    public Mother createMother() {
        return new ChineseMother();
    }

}
