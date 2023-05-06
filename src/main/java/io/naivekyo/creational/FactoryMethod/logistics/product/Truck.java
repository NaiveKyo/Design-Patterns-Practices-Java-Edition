package io.naivekyo.creational.FactoryMethod.logistics.product;

/**
 * 产品具体实现类: 卡车
 */
public class Truck implements Transport {
    @Override
    public void delivery() {
        System.out.println("使用卡车走陆路运输...");
    }
}
