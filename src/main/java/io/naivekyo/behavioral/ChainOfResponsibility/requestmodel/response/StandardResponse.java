package io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.response;

/**
 * 标准响应实现
 */
public class StandardResponse implements Response {
    
    private StringBuilder builder = new StringBuilder();
    
    @Override
    public void flush() {
        // 这里简单的把信息打印到控制台
        System.out.println(builder);
    }

    @Override
    public void write(String message) {
        this.builder.append(message);
    }
    
}
