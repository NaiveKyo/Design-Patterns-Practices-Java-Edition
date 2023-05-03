package io.naivekyo.creational.AbstractFactory;

import io.naivekyo.creational.AbstractFactory.platform.impl.PlatformA;
import io.naivekyo.creational.AbstractFactory.platform.impl.PlatformB;

public class AbstractFactoryTestClient {
    public static void main(String[] args) {
        // Platform A:
        PlatformA.makeProductA().introduce();
        PlatformA.makeProductB().introduce();
        
        // Platform B:
        PlatformB.makeProductA().introduce();
        PlatformB.makeProductB().introduce();
    }
}
