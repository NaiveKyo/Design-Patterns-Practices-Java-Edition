package io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.handler;

import io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.request.Request;
import io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.response.Response;
import io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.support.Order;

public class BaseHandler implements Handler, Order {
    
    private Handler next;
    
    private int order;

    public BaseHandler(int order) {
        this.order = order;
    }

    @Override
    public void setNext(Handler h) {
        this.next = h;
    }

    @Override
    public void handle(Request request, Response response) {
        // 将请求沿着链传递, 达到末尾且没有被终止传递则刷新响应
        boolean support = this.supportHandle(request);
        if (support) {
            boolean done = this.doHandle(request, response);
            if (!done) {
                if (this.next != null)
                    this.next.handle(request,response);
                else {
                    response.write("done.");
                    response.flush();
                }
            } else {
                response.write("done.");
                response.flush();
            }
        } else {
            if (this.next != null)
                this.next.handle(request, response);
            else {
                response.write("done.");
                response.flush();
            }
        }
    }

    /**
     * template method: 处理请求和响应
     * @param request request
     * @param response response
     * @return 是否终止请求传递, true/false
     */
    protected boolean doHandle(Request request, Response response) {
        return false;
    }

    /**
     * 判断当前 Handler 是否能够处理该请求
     * @param request 请求
     * @return true/false
     */
    protected boolean supportHandle(Request request) {
        return false;
    }

    @Override
    public int getOrder() {
        return this.order;
    }
    
}
