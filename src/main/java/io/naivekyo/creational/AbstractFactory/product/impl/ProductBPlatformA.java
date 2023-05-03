package io.naivekyo.creational.AbstractFactory.product.impl;

import io.naivekyo.creational.AbstractFactory.product.AbstractProductB;

public class ProductBPlatformA implements AbstractProductB {
    public void introduce() {
        System.out.printf("Platform: A, %s%n", this.getProductTag());
    }
}
