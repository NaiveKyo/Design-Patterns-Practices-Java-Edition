package io.naivekyo.behavioral.ChainOfResponsibility.requestmodel.support;

/**
 * 顺序, 值越低则越靠前
 */
public interface Order {

    /**
     * 获取序号
     * @return 序号
     */
    int getOrder();
    
    int HIGHEST_ORDER = Integer.MIN_VALUE;
    
    int LOWEST_ORDER = Integer.MAX_VALUE;
    
}
