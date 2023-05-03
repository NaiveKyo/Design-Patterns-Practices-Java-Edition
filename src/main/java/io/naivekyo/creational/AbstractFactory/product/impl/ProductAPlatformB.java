package io.naivekyo.creational.AbstractFactory.product.impl;

import io.naivekyo.creational.AbstractFactory.product.AbstractProductA;

public class ProductAPlatformB implements AbstractProductA {
    public void introduce() {
        System.out.printf("Platform: B, %s%n", this.getProductTag());
    }
}
