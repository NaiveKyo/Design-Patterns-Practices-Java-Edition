package io.naivekyo.behavioral.Observer.editor;

import io.naivekyo.behavioral.Observer.publisher.EventManager;

import java.io.File;

/**
 * @author NaiveKyo
 * @version 1.0
 * @since 2023/6/4 11:19
 */
public class Editor {
    
    public EventManager events;
    
    private File file;

    public Editor() {
        this.events = new EventManager("open", "save");
    }
    
    public void openFile(String filePath) {
        this.file = new File(filePath);
        this.events.notify("open", this.file);
    }
    
    public void saveFile() {
        if (this.file != null) {
            this.events.notify("save", this.file);
        } else {
            throw new RuntimeException("Please open a file first.");
        }
    }
}
