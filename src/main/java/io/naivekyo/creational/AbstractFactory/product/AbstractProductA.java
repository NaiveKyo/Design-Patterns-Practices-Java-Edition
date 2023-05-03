package io.naivekyo.creational.AbstractFactory.product;

public interface AbstractProductA extends Product {
    default String getProductTag() {
        return "Product A";
    }
}
