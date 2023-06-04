package io.naivekyo.behavioral.Observer.listener;

import java.io.File;

/**
 * @author NaiveKyo
 * @version 1.0
 * @since 2023/6/4 11:20
 */
public class EmailNotificationListener implements EventListener {
    
    private String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Email to " + this.email + ": Some has performed " + eventType);
    }
}
