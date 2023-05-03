package io.naivekyo.creational.AbstractFactory.platform.impl;

import io.naivekyo.creational.AbstractFactory.platform.AbstractPlatform;
import io.naivekyo.creational.AbstractFactory.product.AbstractProductA;
import io.naivekyo.creational.AbstractFactory.product.AbstractProductB;
import io.naivekyo.creational.AbstractFactory.product.impl.ProductAPlatformB;
import io.naivekyo.creational.AbstractFactory.product.impl.ProductBPlatformB;

public class PlatformB implements AbstractPlatform {

    // 如果工厂对象的构建需要其他资源才可以, 则可以考虑将工厂对象做成单例对象
    // 本例只演示最简单的用法: 即提供静态方法用于创建具体的产品
    
    public static AbstractProductA makeProductA() {
        return new ProductAPlatformB();
    }
    
    public static AbstractProductB makeProductB() {
        return new ProductBPlatformB();
    }
    
}
