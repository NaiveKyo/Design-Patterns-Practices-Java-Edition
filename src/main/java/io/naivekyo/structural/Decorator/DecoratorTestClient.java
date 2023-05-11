package io.naivekyo.structural.Decorator;

import io.naivekyo.structural.Decorator.impl.QQNotifierDecorator;
import io.naivekyo.structural.Decorator.impl.SMSNotifierDecorator;
import io.naivekyo.structural.Decorator.impl.WeChatNotifierDecorator;

public class DecoratorTestClient {
    public static void main(String[] args) {
        boolean qqNotificationEnable = true;
        boolean weChatNotificationEnable = true;
        
        Notifier decorator = new BaseDecorator(new SMSNotifierDecorator());
        if (qqNotificationEnable)
            decorator = new QQNotifierDecorator(decorator);
        if (weChatNotificationEnable)
            decorator = new WeChatNotifierDecorator(decorator);
        
        decorator.send("test msg");
    }
}
