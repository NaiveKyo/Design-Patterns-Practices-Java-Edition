package io.naivekyo.behavioral.ChainOfResponsibility.requestmodel;

import io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.container.Context;
import io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.handler.BaseHandler;
import io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.handler.CheckPrivilegeHandler;
import io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.handler.Handler;
import io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.handler.RecordLogHandler;
import io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.handler.TestHandler;
import io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.request.Request;
import io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.request.StandardRequest;
import io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.response.Response;
import io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.response.StandardResponse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RequestHandlerChainTestClient {
    
    public static Handler buildCoF(List<BaseHandler> chain) {
        Handler head = chain.get(0);
        Handler h = head;
        for (int i = 1; i < chain.size(); i++) {
            BaseHandler cur = chain.get(i);
            h.setNext(cur);
            h = cur;
        }
        return head;
    }
    
    public static void main(String[] args) {
        // 构造职责链
        List<BaseHandler> handlerChain = new ArrayList<>();
        handlerChain.add(new CheckPrivilegeHandler(100));
        handlerChain.add(new RecordLogHandler(1));
        handlerChain.add(new TestHandler(2));
        handlerChain.sort(Comparator.comparingInt(BaseHandler::getOrder));

        Handler chain = buildCoF(handlerChain);

        // 构造请求
        Request request = new StandardRequest("jack", Context.Privilege.CREATE_ORDER.getName());
        Response response = new StandardResponse();
        
        chain.handle(request, response);
    }
}
