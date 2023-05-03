package io.naivekyo.creational.Bridge.abstraction;

import io.naivekyo.creational.Bridge.implementation.SwitchImplementation;

/**
 * 开关的抽象非常简单, 只有两个功能: 开/关
 * 此类代表: body
 */
public abstract class Switch {
    
    protected SwitchImplementation implementation;

    public Switch(SwitchImplementation implementation) {
        this.implementation = implementation;
    }

    public abstract void on();
    
    public abstract void off();
    
    public void setImplementation(SwitchImplementation implementation) {
        this.implementation = implementation;
    }
    
}
