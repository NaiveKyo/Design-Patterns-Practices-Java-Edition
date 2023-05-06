package io.naivekyo.creational.FactoryMethod.logistics.product;

/**
 * 产品具体实现类: 轮船
 */
public class Ship implements Transport {
    @Override
    public void delivery() {
        System.out.println("使用轮船走海路运输...");
    }
}
