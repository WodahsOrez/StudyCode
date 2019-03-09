package pattern.composite.safe;

import java.util.ArrayList;

/**
 * @Description  树枝构件
 * @author  WodahsOrez
 * @date 2018年6月8日 上午10:24:09 
 *  
 */
public class Composite extends AbstractComponent {
    /** 构件容器 */
    private ArrayList<AbstractComponent> componentList = new ArrayList<AbstractComponent>();
    
    /**  
     * @Description  增加一个构件
     */
    public void add(AbstractComponent component) {
        component.setParent(this);
        this.componentList.add(component);
    }

    /**  
     * @Description  删除一个构件
     */
    public void remove(AbstractComponent component) {
        this.componentList.remove(component);
    }
    
    /**  
     * @Description  获取分支下的所有构件
     */
    public ArrayList<AbstractComponent> getChildren() {
        return this.componentList;
    }
}
