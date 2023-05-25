package io.naivekyo.behavioral.Mediator;

import io.naivekyo.behavioral.Mediator.components.AddButton;
import io.naivekyo.behavioral.Mediator.components.DeleteButton;
import io.naivekyo.behavioral.Mediator.components.Filter;
import io.naivekyo.behavioral.Mediator.components.List;
import io.naivekyo.behavioral.Mediator.components.SaveButton;
import io.naivekyo.behavioral.Mediator.components.TextBox;
import io.naivekyo.behavioral.Mediator.components.Title;
import io.naivekyo.behavioral.Mediator.mediator.Editor;
import io.naivekyo.behavioral.Mediator.mediator.Mediator;

import javax.swing.*;

public class MediatorTestClient {
    public static void main(String[] args) {
        Mediator mediator = new Editor();

        mediator.registerComponent(new Title());
        mediator.registerComponent(new TextBox());
        mediator.registerComponent(new AddButton());
        mediator.registerComponent(new DeleteButton());
        mediator.registerComponent(new SaveButton());
        mediator.registerComponent(new List(new DefaultListModel()));
        mediator.registerComponent(new Filter());

        mediator.createGUI();
    }
}
