package io.naivekyo.structural.Decorator;

public class BaseDecorator implements Notifier {
    
    private Notifier wrapper;

    public BaseDecorator() {
    }

    public BaseDecorator(Notifier wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public void send(String message) {
        if (this.wrapper != null)
            this.wrapper.send(message);
    }
}
