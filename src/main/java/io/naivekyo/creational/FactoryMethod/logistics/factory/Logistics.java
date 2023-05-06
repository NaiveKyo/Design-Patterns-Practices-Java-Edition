package io.naivekyo.creational.FactoryMethod.logistics.factory;

import io.naivekyo.creational.FactoryMethod.logistics.product.Transport;

/**
 * 抽象简单工厂基类: 定义了物流工厂创建物流方式的通用方法
 */
public abstract class Logistics {

    /**
     * 通常情况下客户端不关系具体的物流实现 <br/>
     * 客户端认为只需调用此方法传入具体的货物即可进行运输
     */
    public void planDelivery() {
        Transport t = this.createTransport();
        t.delivery();
    }

    /**
     * 定义创建产品的抽象方法, 具体的产品实现由工厂实现子类决定
     * @return 具体的运输方式实现
     */
    public abstract Transport createTransport();
    
}
