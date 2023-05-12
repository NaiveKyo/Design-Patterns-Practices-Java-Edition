package io.naivekyo.structural.Decorator.decorator;

import io.naivekyo.structural.Decorator.component.Notifier;

public class NotifierDecorator implements Notifier {
    
    protected Notifier wrapper;

    public NotifierDecorator(Notifier wrapper) {
        this.wrapper = wrapper;
    }

    // 基类装饰器会将具体工作委派给被封装的组件
    @Override
    public void send(String message) {
        this.wrapper.send(message);
    }
    
}
