package io.naivekyo.behavioral.Mediator.components;

import io.naivekyo.behavioral.Mediator.mediator.Mediator;
import io.naivekyo.behavioral.Mediator.mediator.Note;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddButton extends JButton implements Component {
    
    private Mediator mediator;

    public AddButton() {
        super("Add");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void fireActionPerformed(ActionEvent event) {
        this.mediator.addNewNote(new Note());
    }

    @Override
    public String getName() {
        return "AddButton";
    }
}
