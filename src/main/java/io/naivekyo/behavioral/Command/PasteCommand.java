package io.naivekyo.behavioral.Command;

public class PasteCommand extends Command {
    
    public PasteCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if (this.getEditor().getClipboard() == null || this.getEditor().getClipboard().isEmpty()) {
            return false;
        }
        // 先备份当前状态
        this.backup();
        this.getEditor().getTextField().insert(this.getEditor().getClipboard(), this.getEditor().getTextField().getCaretPosition());
        return true;
    }
}
