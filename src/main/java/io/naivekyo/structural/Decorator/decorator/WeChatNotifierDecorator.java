package io.naivekyo.structural.Decorator.decorator;

import io.naivekyo.structural.Decorator.component.Notifier;

public class WeChatNotifierDecorator extends NotifierDecorator {

    public WeChatNotifierDecorator(Notifier wrapper) {
        super(wrapper);
    }

    // 具体装饰器子类可以在调用被封装对象之前或之后做一些操作
    @Override
    public void send(String message) {
        super.send(message);
        this.sendWeChat(message);
    }
    
    protected void sendWeChat(String message) {
        System.out.println("Notification facility: WeChat :: msg :: " + message);
    }
}
