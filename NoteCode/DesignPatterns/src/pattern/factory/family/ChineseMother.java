package pattern.factory.family;

/**
 * @Description  中国母亲
 * @author  WodahsOrez
 * @date 2018年6月5日 上午8:47:55 
 *  
 */
public class ChineseMother implements Mother {

    /**  
     * @Description  中国母亲自我介绍    
     */
    @Override
    public void say() {
        System.out.println("我是中国母亲.");
    }

}
