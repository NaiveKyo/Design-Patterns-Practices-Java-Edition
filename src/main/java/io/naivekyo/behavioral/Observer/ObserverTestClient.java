package io.naivekyo.behavioral.Observer;

import io.naivekyo.behavioral.Observer.editor.Editor;
import io.naivekyo.behavioral.Observer.listener.EmailNotificationListener;
import io.naivekyo.behavioral.Observer.listener.LogOpenListener;

/**
 * @author NaiveKyo
 * @version 1.0
 * @since 2023/6/4 11:29
 */
public class ObserverTestClient {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("E:\\IDEA Java SE Codeing\\Design-Pattern-Practices\\src\\main\\java\\io\\naivekyo\\behavioral\\Observer\\file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("xxx@xxx.com"));
        
        editor.openFile("E:\\IDEA Java SE Codeing\\Design-Pattern-Practices\\src\\main\\java\\io\\naivekyo\\behavioral\\Observer\\test.txt");
        editor.saveFile();
    }
}
