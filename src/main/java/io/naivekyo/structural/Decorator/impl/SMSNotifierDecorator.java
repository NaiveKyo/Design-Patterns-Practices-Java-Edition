package io.naivekyo.structural.Decorator.impl;

import io.naivekyo.structural.Decorator.BaseDecorator;
import io.naivekyo.structural.Decorator.Notifier;

public class SMSNotifierDecorator extends BaseDecorator {

    public SMSNotifierDecorator() {
    }

    public SMSNotifierDecorator(Notifier wrapper) {
        super(wrapper);
    }

    @Override
    public void send(String message) {
        super.send(message);
        this.sendSMS(message);
    }
    
    protected void sendSMS(String message) {
        System.out.println("Notification facility: SMS");
    }
    
}
