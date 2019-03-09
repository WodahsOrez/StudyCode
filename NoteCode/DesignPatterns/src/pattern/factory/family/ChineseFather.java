package pattern.factory.family;

/**
 * @Description  中国父亲
 * @author  WodahsOrez
 * @date 2018年6月5日 上午8:47:12 
 *  
 */
public class ChineseFather implements Father {

    /**  
     * @Description  中国父亲自我介绍
     */
    @Override
    public void say() {
        System.out.println("我是中国父亲");
    }

}
