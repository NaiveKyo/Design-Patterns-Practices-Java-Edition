package io.naivekyo.structural.Decorator.component;

public class SMSNotifier implements Notifier {
 
    @Override
    public void send(String message) {
        this.sendSMS(message);
    }
    
    protected void sendSMS(String message) {
        System.out.println("Notification facility: SMS :: msg :: " + message);
    }
    
}
