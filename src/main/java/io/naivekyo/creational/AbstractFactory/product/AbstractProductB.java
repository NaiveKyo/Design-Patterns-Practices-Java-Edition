package io.naivekyo.creational.AbstractFactory.product;

public interface AbstractProductB extends Product {
    default String getProductTag() {
        return "Product B";
    }
}
