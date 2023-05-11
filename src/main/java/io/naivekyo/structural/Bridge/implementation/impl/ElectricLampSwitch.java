package io.naivekyo.structural.Bridge.implementation.impl;

import io.naivekyo.structural.Bridge.implementation.SwitchImplementation;

public class ElectricLampSwitch implements SwitchImplementation {

    /**
     * 灯可以调亮或调暗, 这个字段表示灯光的亮度
     * 0 表示熄灭
     */
    private int level = 0;
    
    @Override
    public void on() {
        if (this.level == 0) {
            this.level++;
            System.out.printf("Turn on the light. [level: %d]%n", this.level);
        } else if (this.level == 1) {
            this.level++;
            System.out.printf("Up the light level. [level: %d]%n", this.level);
        } else if (this.level == 2) {
            System.out.println("Can't up light level, it's already maximum.");
        }
    }

    @Override
    public void off() {
        if (this.level == 2) {
            this.level--;
            System.out.printf("Down the light level. [level: %d]%n", this.level);
        } else if (this.level == 1) {
            this.level--;
            System.out.printf("Turn off the light. [level: %d]%n", this.level);
        } else if (this.level == 0) {
            System.out.println("Can't down light level, it's already minimum.");
        }
    }
}
