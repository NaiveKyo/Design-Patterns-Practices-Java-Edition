package io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.handler;

import io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.request.Request;
import io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.response.Response;

public class TestHandler extends BaseHandler {
    
    public TestHandler(int order) {
        super(order);
    }

    @Override
    protected boolean doHandle(Request request, Response response) {
        response.write(String.format("[%s : test handler] ", this.getClass().getSimpleName()));
        return false;
    }

    @Override
    protected boolean supportHandle(Request request) {
        return true;
    }
}
