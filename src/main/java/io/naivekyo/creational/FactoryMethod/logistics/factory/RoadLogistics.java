package io.naivekyo.creational.FactoryMethod.logistics.factory;

import io.naivekyo.creational.FactoryMethod.logistics.product.Transport;
import io.naivekyo.creational.FactoryMethod.logistics.product.Truck;

/**
 * 具体工厂实现类: 陆路运输方式
 */
public class RoadLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
