package io.naivekyo.structural.Bridge.abstraction.impl;

import io.naivekyo.structural.Bridge.abstraction.Switch;
import io.naivekyo.structural.Bridge.implementation.SwitchImplementation;

public class SimpleSwitch extends Switch {

    public SimpleSwitch(SwitchImplementation implementation) {
        super(implementation);
    }

    @Override
    public void on() {
        this.implementation.on();
    }

    @Override
    public void off() {
        this.implementation.off();
    }
}
