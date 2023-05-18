package io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.request;

/**
 * 对请求的抽象, 简单的认为一个请求应当包括用户和要进行的操作
 */
public interface Request {
    
    String getUsername();
    
    String getPrivilege();
    
}
