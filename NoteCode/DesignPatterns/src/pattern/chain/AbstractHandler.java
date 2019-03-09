package pattern.chain;

/**
 * @Description  抽象处理者类
 * @author  WodahsOrez
 * @date 2018年6月6日 下午1:09:24 
 *  
 */
public abstract class AbstractHandler {
    /** 存放下一个处理者 */
    private AbstractHandler nextHandler;
    
    /**  
     * @Description  对请求作出处理
     */
    public final Response handleMessage(Request request) {
        Response response = null;
        if (this.getHandlerLevel().equals(request.getRequestLevel())) {
            response = this.echo(request);
        } else {
            if (this.nextHandler != null) {
                response = this.nextHandler.handleMessage(request);
            } else {
                // 当没有适当的处理者,业务自行处理
            }
        }
        return response;
    }

    /**  
     * @Description  设置下一个处理者
     */
    public void setNext(AbstractHandler handler) {
        this.nextHandler = handler;
    }
    
    /**  
     * @Description  获取处理者的处等级
     * @return   
     */
    protected abstract Level getHandlerLevel();
    
    protected abstract Response echo(Request request);
}
