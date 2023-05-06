package io.naivekyo.creational.FactoryMethod.logistics.product;

/**
 * 产品接口: 定义物流使用的运输载体的通用行为
 */
public interface Transport {

    /**
     * 所有运输工具都能够运输货物
     */
    void delivery();
    
}
