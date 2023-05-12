package io.naivekyo.structural.Decorator;

import io.naivekyo.structural.Decorator.decorator.QQNotifierDecorator;
import io.naivekyo.structural.Decorator.component.Notifier;
import io.naivekyo.structural.Decorator.component.SMSNotifier;
import io.naivekyo.structural.Decorator.decorator.WeChatNotifierDecorator;

public class DecoratorTestClient {
    public static void main(String[] args) {
        boolean qqNotificationEnable = true;
        boolean weChatNotificationEnable = true;
        
        Notifier notifier = new SMSNotifier();
        
        // 这里模拟程序在运行时根据不同的配置启用不同的装饰
        if (qqNotificationEnable)
            notifier = new QQNotifierDecorator(notifier);
        if (weChatNotificationEnable)
            notifier = new WeChatNotifierDecorator(notifier);

        notifier.send("test msg");
    }
}
