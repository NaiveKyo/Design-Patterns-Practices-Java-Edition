package io.naivekyo.behavioral.Memento.history;

import io.naivekyo.behavioral.Memento.editor.Editor;

/**
 * @author NaiveKyo
 * @version 1.0
 * @since 2023/5/30 22:02
 */
public class Memento {
    
    private String backup;
    
    private Editor editor;

    public Memento(Editor editor) {
        this.editor = editor;
        this.backup = editor.backup();
    }
    
    public void restore() {
        this.editor.restore(this.backup);
    }
}
