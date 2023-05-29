package io.naivekyo.behavioral.Memento.shape;

import java.awt.*;

/**
 * @author NaiveKyo
 * @version 1.0
 * @since 2023/5/27 10:28
 */
public class Dot extends BaseShape {
    
    private final int DOT_SIZE = 3;

    public Dot(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public int getWidth() {
        return DOT_SIZE;
    }

    @Override
    public int getHeight() {
        return DOT_SIZE;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.fillRect(getX() - 1, getY() - 1, getWidth(), getHeight());
    }
    
}
