package io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.handler;

import io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.request.Request;
import io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.response.Response;

public class RecordLogHandler extends BaseHandler {
    
    public RecordLogHandler(int order) {
        super(order);
    }

    @Override
    protected boolean doHandle(Request request, Response response) {
        if (this.supportHandle(request)) {
            System.out.printf("[LOGGER]: %s [user]: %s [do]: %s%n", this.getClass().getSimpleName(), request.getUsername(), request.getPrivilege());
        }
        // 继续传递
        return false;
    }

    @Override
    protected boolean supportHandle(Request request) {
        return true;
    }
    
}
