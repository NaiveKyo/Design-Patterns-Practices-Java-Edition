package io.naivekyo.creational.Adatper.adapter;

import io.naivekyo.creational.Adatper.Shape;
import io.naivekyo.creational.Adatper.legacy.LegacyRectangle;

/**
 * 新的 Rectangle class
 */
public class Rectangle implements Shape {
    
    private LegacyRectangle adaptee;

    public Rectangle(LegacyRectangle adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void display(int x1, int y1, int x2, int y2) {
        // call adaptee's legacy method
        System.out.println("call adapter' display method.");
        this.adaptee.display(x1, y1, (x2 - x1), (y2 - y1));
    }
}
