package io.naivekyo.behavioral.Mediator.components;

import io.naivekyo.behavioral.Mediator.mediator.Mediator;
import io.naivekyo.behavioral.Mediator.mediator.Note;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Filter extends JTextField implements Component {
    
    private Mediator mediator;
    
    private ListModel listModel;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void processComponentKeyEvent(KeyEvent e) {
        String start = this.getText();
        searchElements(start);
    }

    public void setList(ListModel listModel) {
        this.listModel = listModel;
    }
    
    private void searchElements(String s) {
        if (this.listModel == null) {
            return;
        }
        
        if ("".equals(s)) {
            this.mediator.setElementsList(listModel);
            return;
        }

        ArrayList<Note> notes = new ArrayList<>();
        for (int i = 0; i < this.listModel.getSize(); i++) {
            notes.add((Note) this.listModel.getElementAt(i));
        }
        DefaultListModel<Note> listModel = new DefaultListModel<>();
        for (Note note : notes) {
            if (note.getName().contains(s))
                listModel.addElement(note);
        }
        this.mediator.setElementsList(listModel);
    }

    @Override
    public String getName() {
        return "Filter";
    }
}
