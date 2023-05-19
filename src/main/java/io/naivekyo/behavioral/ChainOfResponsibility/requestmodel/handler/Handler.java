package io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.handler;

import io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.request.Request;
import io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.response.Response;

/**
 * 处理者接口, 定义通用行为
 */
public interface Handler {
    
    void setNext(Handler h);
    
    void handle(Request request, Response response);
    
}
