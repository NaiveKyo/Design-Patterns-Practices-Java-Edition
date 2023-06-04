package io.naivekyo.behavioral.Observer.publisher;

import io.naivekyo.behavioral.Observer.listener.EventListener;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author NaiveKyo
 * @version 1.0
 * @since 2023/6/4 11:19
 */
public class EventManager {
    
    Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }
    
    public void subscribe(String eventType, EventListener listener) {
        List<EventListener> users = this.listeners.get(eventType);
        users.add(listener);
    }
    
    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> users = this.listeners.get(eventType);
        users.remove(listener);
    }
    
    public void notify(String eventType, File file) {
        List<EventListener> users = this.listeners.get(eventType);
        for (EventListener listener : users) {
            listener.update(eventType, file);
        }
    }
}
