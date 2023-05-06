package io.naivekyo.creational.FactoryMethod.logistics;

import io.naivekyo.creational.FactoryMethod.logistics.factory.Logistics;
import io.naivekyo.creational.FactoryMethod.logistics.factory.RoadLogistics;
import io.naivekyo.creational.FactoryMethod.logistics.factory.SeaLogistics;

/**
 * 工厂方法模式在物流体系中的实现, 对应的测试 Client
 */
public class LogisticsFactoryMethodTestClient {
    public static void main(String[] args) {
        Logistics roadLogistics = new RoadLogistics();
        Logistics seaLogistics = new SeaLogistics();
        
        // 实际环境中这里应该传递要运输的 "货物"
        roadLogistics.planDelivery();
        seaLogistics.planDelivery();
    }
}
