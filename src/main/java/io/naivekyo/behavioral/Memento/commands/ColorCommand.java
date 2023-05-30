package io.naivekyo.behavioral.Memento.commands;

import io.naivekyo.behavioral.Memento.editor.Editor;
import io.naivekyo.behavioral.Memento.shape.Shape;

import java.awt.*;

/**
 * 改变选中的 shape 的颜色
 */
public class ColorCommand implements Command {
    
    private Editor editor;
    
    private Color color;

    public ColorCommand(Editor editor, Color color) {
        this.editor = editor;
        this.color = color;
    }

    @Override
    public String getName() {
        return "Colorize: " + this.color.toString();
    }

    @Override
    public void execute() {
        for (Shape child : this.editor.getShapes().getSelected()) {
            child.setColor(this.color);
        }
    }
}
