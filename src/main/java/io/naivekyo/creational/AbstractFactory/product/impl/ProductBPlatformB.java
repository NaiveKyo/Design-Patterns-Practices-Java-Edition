package io.naivekyo.creational.AbstractFactory.product.impl;

import io.naivekyo.creational.AbstractFactory.product.AbstractProductB;

public class ProductBPlatformB implements AbstractProductB {
    public void introduce() {
        System.out.printf("Platform: B, %s%n", this.getProductTag());
    }
}
