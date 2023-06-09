package io.naivekyo.behavioral.Command;

public abstract class Command {
    
    private Editor editor;
    
    private String backup;

    public Command(Editor editor) {
        this.editor = editor;
    }

    public Editor getEditor() {
        return editor;
    }

    public String getBackup() {
        return backup;
    }

    public void backup() {
        this.backup = this.editor.getTextField().getText();
    }
    
    public void undo() {
        this.editor.getTextField().setText(this.backup);
    }

    /**
     * 通过的触发命令执行的方法
     * @return 是否执行
     */
    public abstract boolean execute();
    
}
