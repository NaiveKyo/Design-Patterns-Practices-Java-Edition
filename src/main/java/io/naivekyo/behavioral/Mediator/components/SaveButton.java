package io.naivekyo.behavioral.Mediator.components;

import io.naivekyo.behavioral.Mediator.mediator.Mediator;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SaveButton extends JButton implements Component {
    
    private Mediator mediator;

    public SaveButton() {
        super("Save");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void fireActionPerformed(ActionEvent event) {
        this.mediator.saveChanges();
    }

    @Override
    public String getName() {
        return "SaveButton";
    }
}
