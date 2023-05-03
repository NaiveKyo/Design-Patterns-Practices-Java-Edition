package io.naivekyo.creational.AbstractFactory.product.impl;

import io.naivekyo.creational.AbstractFactory.product.AbstractProductA;

public class ProductAPlatformA implements AbstractProductA {
    public void introduce() {
        System.out.printf("Platform: A, %s%n", this.getProductTag());
    }
}
