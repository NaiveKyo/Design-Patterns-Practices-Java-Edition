package io.naivekyo.behavioral.Observer.listener;

import java.io.File;

/**
 * @author NaiveKyo
 * @version 1.0
 * @since 2023/6/4 11:20
 */
public interface EventListener {
    void update(String eventType, File file);
}
