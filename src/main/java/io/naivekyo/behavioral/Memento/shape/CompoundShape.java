package io.naivekyo.behavioral.Memento.shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author NaiveKyo
 * @version 1.0
 * @since 2023/5/27 10:34
 */
public class CompoundShape extends BaseShape {
    
    private List<Shape> children = new ArrayList<>();
    
    public CompoundShape(Shape... components) {
        super(0, 0, Color.BLACK);
        this.add(components);
    }
    
    public void add(Shape component) {
        this.children.add(component);
    }
    
    public void add(Shape... components) {
        this.children.addAll(Arrays.asList(components));
    }
    
    public void remove(Shape child) {
        this.children.remove(child);
    }
    
    public void remove(Shape... components) {
        this.children.removeAll(Arrays.asList(components));
    }
    
    public void clear() {
        this.children.clear();
    }

    @Override
    public int getX() {
        if (this.children.size() == 0)
            return 0;
        int x = this.children.get(0).getX();
        for (Shape child : children) {
            if (child.getX() < x) {
                x = child.getX();
            }
        }
        return x;
    }

    @Override
    public int getY() {
        if (this.children.size() == 0)
            return 0;
        int y = this.children.get(0).getY();
        for (Shape child : children) {
            if (child.getY() < y) {
                y = child.getY();
            }
        }
        return y;
    }

    @Override
    public int getWidth() {
        int maxWidth = 0;
        int x = getX();
        for (Shape child : this.children) {
            int childRelativeX = child.getX() - x;
            int childWidth = childRelativeX + child.getWidth();
            if (childWidth > maxWidth) {
                maxWidth = childWidth;
            }
        }
        return maxWidth;
    }

    @Override
    public int getHeight() {
        int maxHeight = 0;
        int y = getY();
        for (Shape child : children) {
            int childRelativeY = child.getY() - y;
            int childHeight = childRelativeY + child.getHeight();
            if (childHeight > maxHeight) {
                maxHeight = childHeight;
            }
        }
        return maxHeight;
    }

    @Override
    public void drag() {
        for (Shape child : children) {
            child.drag();
        }
    }

    @Override
    public void drop() {
        for (Shape child : children) {
            child.drop();
        }
    }

    @Override
    public void moveTo(int x, int y) {
        for (Shape child : children) {
            child.moveTo(x, y);
        }
    }

    @Override
    public void moveBy(int x, int y) {
        for (Shape child : children) {
            child.moveBy(x, y);
        }
    }

    @Override
    public boolean isInsideBounds(int x, int y) {
        for (Shape child : children) {
            if (child.isInsideBounds(x, y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setColor(Color color) {
        super.setColor(color);
        for (Shape child : children) {
            child.setColor(color);
        }
    }

    @Override
    public void unSelect() {
        super.unSelect();
        for (Shape child : children) {
            child.unSelect();
        }
    }
}
