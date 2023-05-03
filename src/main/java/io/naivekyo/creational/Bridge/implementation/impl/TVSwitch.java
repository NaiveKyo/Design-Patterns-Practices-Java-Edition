package io.naivekyo.creational.Bridge.implementation.impl;

import io.naivekyo.creational.Bridge.implementation.SwitchImplementation;

/**
 * 电视开关只有两种状态: 打开或者关闭
 */
public class TVSwitch implements SwitchImplementation {
    
    @Override
    public void on() {
        System.out.println("Turn on the TV.");
    }

    @Override
    public void off() {
        System.out.println("Turn off the TV.");
    }
    
}
