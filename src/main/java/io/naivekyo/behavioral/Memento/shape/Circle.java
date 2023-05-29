package io.naivekyo.behavioral.Memento.shape;

import java.awt.*;

/**
 * @author NaiveKyo
 * @version 1.0
 * @since 2023/5/27 10:25
 */
public class Circle extends BaseShape {
    
    private int radius;
    
    public Circle(int x, int y, int radius, Color color) {
        super(x, y, color);
        this.radius = radius;
    }

    @Override
    public int getWidth() {
        return this.radius << 1;
    }

    @Override
    public int getHeight() {
        return this.radius << 1;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.drawOval(getX(), getY(), getWidth() - 1, getHeight() - 1);
    }
    
}
