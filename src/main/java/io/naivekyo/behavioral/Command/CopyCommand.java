package io.naivekyo.behavioral.Command;

public class CopyCommand extends Command {
    
    public CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        this.getEditor().setClipboard(this.getEditor().getTextField().getSelectedText());
        return false;
    }
    
}
