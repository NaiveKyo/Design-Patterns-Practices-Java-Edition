package io.naivekyo.behavioral.Memento;

import io.naivekyo.behavioral.Memento.editor.Editor;
import io.naivekyo.behavioral.Memento.shape.Circle;
import io.naivekyo.behavioral.Memento.shape.CompoundShape;
import io.naivekyo.behavioral.Memento.shape.Dot;
import io.naivekyo.behavioral.Memento.shape.Rectangle;

import java.awt.*;

/**
 * @author NaiveKyo
 * @version 1.0
 * @since 2023/5/30 22:11
 */
public class MementoTestClient {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.loadShapes(
                new Circle(10, 10, 10, Color.BLUE),
                new CompoundShape(
                        new Circle(110, 110, 50, Color.RED),
                        new Dot(160, 160, Color.RED)
                ),
                new CompoundShape(
                        new Rectangle(250, 250, 100, 100, Color.GREEN),
                        new Dot(240, 240, Color.GREEN),
                        new Dot(240, 360, Color.GREEN),
                        new Dot(360, 360, Color.GREEN),
                        new Dot(360, 240, Color.GREEN)
                )
        );
    }
}
