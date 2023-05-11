package io.naivekyo.structural.Decorator.impl;

import io.naivekyo.structural.Decorator.BaseDecorator;
import io.naivekyo.structural.Decorator.Notifier;

public class QQNotifierDecorator extends BaseDecorator {

    public QQNotifierDecorator() {
    }

    public QQNotifierDecorator(Notifier wrapper) {
        super(wrapper);
    }

    @Override
    public void send(String message) { 
        super.send(message);
        this.sendQQ(message);
    }
    
    protected void sendQQ(String message) { 
        System.out.println("Notification facility: QQ");
    }
}
