package io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.response;

/**
 * 对响应的抽象
 */
public interface Response {

    /**
     * 打印响应信息
     */
    void flush();

    /**
     * 写入响应消息
     * @param message 提示信息
     */
    void write(String message);
    
}
