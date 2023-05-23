package io.naivekyo.behavioral.Command;

public class CutCommand extends Command {
    
    public CutCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if (this.getEditor().getTextField().getSelectedText().isEmpty())
            return false;
        this.backup();
        
        String source = this.getEditor().getTextField().getText();
        this.getEditor().setClipboard(this.getEditor().getTextField().getSelectedText());
        this.getEditor().getTextField().setText(this.cutString(source));
        return true;
    }
    
    private String cutString(String source) {
        String start = source.substring(0, this.getEditor().getTextField().getSelectionStart());
        String end = source.substring(this.getEditor().getTextField().getSelectionEnd());
        return start + end;
    }
}
