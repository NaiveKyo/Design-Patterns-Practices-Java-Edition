package io.naivekyo.structural.Adatper;

import io.naivekyo.structural.Adatper.adapter.Rectangle;
import io.naivekyo.structural.Adatper.legacy.LegacyRectangle;

public class AdapterTestClient {
    public static void main(String[] args) {
        Shape shape = new Rectangle(new LegacyRectangle());
        shape.display(1, 2, 3, 4);
    }
}
