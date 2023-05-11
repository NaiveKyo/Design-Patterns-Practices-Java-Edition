package io.naivekyo.structural.Decorator.impl;

import io.naivekyo.structural.Decorator.BaseDecorator;
import io.naivekyo.structural.Decorator.Notifier;

public class WeChatNotifierDecorator extends BaseDecorator {

    public WeChatNotifierDecorator() {
    }

    public WeChatNotifierDecorator(Notifier wrapper) {
        super(wrapper);
    }

    @Override
    public void send(String message) {
        super.send(message);
        this.sendWeChat(message);
    }
    
    protected void sendWeChat(String message) {
        System.out.println("Notification facility: WeChat");
    }
}
