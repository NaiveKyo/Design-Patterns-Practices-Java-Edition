package io.naivekyo.behavioral.Memento.shape;

import java.awt.*;

/**
 * @author NaiveKyo
 * @version 1.0
 * @since 2023/5/27 10:30
 */
public class Rectangle extends BaseShape {
    
    private int width;
    
    private int height;

    public Rectangle(int x, int y, int width, int height, Color color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.drawRect(getX(), getY(), this.getWidth() - 1, this.getHeight() - 1);
    }
}
