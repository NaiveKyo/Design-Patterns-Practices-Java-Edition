package io.naivekyo.creational.FactoryMethod.logistics.factory;

import io.naivekyo.creational.FactoryMethod.logistics.product.Ship;
import io.naivekyo.creational.FactoryMethod.logistics.product.Transport;

/**
 * 具体工厂实现类: 海路运输方式
 */
public class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
