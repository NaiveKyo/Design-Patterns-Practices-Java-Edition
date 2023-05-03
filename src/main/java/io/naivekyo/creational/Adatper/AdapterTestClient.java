package io.naivekyo.creational.Adatper;

import io.naivekyo.creational.Adatper.adapter.Rectangle;
import io.naivekyo.creational.Adatper.legacy.LegacyRectangle;

public class AdapterTestClient {
    public static void main(String[] args) {
        Shape shape = new Rectangle(new LegacyRectangle());
        shape.display(1, 2, 3, 4);
    }
}
