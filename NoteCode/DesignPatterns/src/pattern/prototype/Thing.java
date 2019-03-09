package pattern.prototype;

import java.util.ArrayList;

/**
 * @Description  原型模式就是要实现拷贝
 * @author  WodahsOrez
 * @date 2018年6月6日 上午8:27:20 
 *  
 */
public class Thing implements Cloneable{
    /** 非基础类型的可变引用型变量,在浅拷贝时是不会被拷贝的 */
    private ArrayList<String> arrayList = new ArrayList<String>();

    /**  
     * @Description  Cloneable的接口是没有方法的,覆盖的是Object的clone方法
     * @return    拷贝后的实例类
     */
    @Override
    protected Object clone() {
        Thing thing = null;
        try {
            // 调用Object的clone完成浅拷贝
            thing = (Thing)super.clone();
            // 手动拷贝arraylist来实现深拷贝
            thing.arrayList = (ArrayList<String>) this.arrayList.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return thing;
    }
}
