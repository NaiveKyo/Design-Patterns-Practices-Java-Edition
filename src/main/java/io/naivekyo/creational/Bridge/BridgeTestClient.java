package io.naivekyo.creational.Bridge;

import io.naivekyo.creational.Bridge.abstraction.Switch;
import io.naivekyo.creational.Bridge.abstraction.impl.DimmerSwitch;
import io.naivekyo.creational.Bridge.abstraction.impl.SimpleSwitch;
import io.naivekyo.creational.Bridge.implementation.impl.ElectricLampSwitch;
import io.naivekyo.creational.Bridge.implementation.impl.TVSwitch;

public class BridgeTestClient {
    public static void main(String[] args) {
        Switch simple = new SimpleSwitch(new TVSwitch());
        simple.on();
        simple.off();

        System.out.println("============================================");
        
        Switch dimmer = new DimmerSwitch(new ElectricLampSwitch());
        dimmer.on();
        dimmer.on();
        dimmer.on();
        dimmer.off();
        dimmer.off();
        dimmer.off();
    }
}
