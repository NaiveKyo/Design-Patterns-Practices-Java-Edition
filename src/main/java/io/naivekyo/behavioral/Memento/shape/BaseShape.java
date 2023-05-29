package io.naivekyo.behavioral.Memento.shape;

import java.awt.*;

/**
 * @author NaiveKyo
 * @version 1.0
 * @since 2023/5/27 10:04
 */
public abstract class BaseShape implements Shape {
    
    int x, y;
    
    private int dx = 0, dy = 0;
    
    private Color color;
    
    private boolean selected = false;

    public BaseShape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void drag() {
        this.dx = this.x;
        this.dy = this.y;
    }

    @Override
    public void drop() {
        this.x = this.dx;
        this.y = this.dy;
    }

    @Override
    public void moveTo(int x, int y) {
        this.x = this.dx + x;
        this.y = this.dy + y;
    }

    @Override
    public void moveBy(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public boolean isInsideBounds(int x, int y) {
        return x > this.getX() && x < (this.getX() + this.getWidth()) 
                && y > this.getY() && y < (this.getY() + this.getHeight());
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void select() {
        this.selected = true;
    }

    @Override
    public void unSelect() {
        this.selected = false;
    }

    @Override
    public boolean isSelected() {
        return this.selected;
    }
    
    void enableSelectionStyle(Graphics graphics) {
        graphics.setColor(Color.LIGHT_GRAY);
        Graphics2D g2 = (Graphics2D) graphics;
        float[] dash1 = { 2.0f };
        g2.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 2.0f, dash1, 0.0f));
    }
    
    void disableSelectionStyle(Graphics graphics) {
        graphics.setColor(this.color);
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setStroke(new BasicStroke());
    }

    @Override
    public void paint(Graphics graphics) {
        if (this.isSelected()) {
            this.enableSelectionStyle(graphics);
        } else {
            this.disableSelectionStyle(graphics);
        }
        // ...
    }
}
