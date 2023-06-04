package io.naivekyo.behavioral.Observer.listener;

import java.io.File;

/**
 * @author NaiveKyo
 * @version 1.0
 * @since 2023/6/4 11:22
 */
public class LogOpenListener implements EventListener {
    
    private File log;

    public LogOpenListener(String fileName) {
        this.log = new File(fileName);
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Save to log " + this.log + ": Some has performed " + eventType);
    }
}
