package io.naivekyo.behavioral.Mediator.components;

import io.naivekyo.behavioral.Mediator.mediator.Mediator;
import io.naivekyo.behavioral.Mediator.mediator.Note;

import javax.swing.*;

@SuppressWarnings("unchecked")
public class List extends JList implements Component {
    
    private Mediator mediator;
    
    private final DefaultListModel LIST_MODEL;

    public List(DefaultListModel listModel) {
        super(listModel);
        this.LIST_MODEL = listModel;
        this.setModel(listModel);
        this.setLayoutOrientation(JList.VERTICAL);
        Thread thread = new Thread(new Hide(this));
        thread.start();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
    
    public void addElement(Note note) {
        LIST_MODEL.addElement(note);
        int index = LIST_MODEL.size() - 1;
        this.setSelectedIndex(index);
        this.ensureIndexIsVisible(index);
        this.mediator.sendToFilter(LIST_MODEL);
    }
    
    public void deleteElement() {
        int index = this.getSelectedIndex();
        try {
            LIST_MODEL.remove(index);
            this.mediator.sendToFilter(LIST_MODEL);
        } catch (ArrayIndexOutOfBoundsException e) {}
    }
    
    public Note getCurrentElement() {
        return (Note) this.getSelectedValue();
    }

    @Override
    public String getName() {
        return "List";
    }
    
    private class Hide implements Runnable {
        private List list;

        public Hide(List list) {
            this.list = list;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (this.list.isSelectionEmpty()) {
                    mediator.hideElements(true);
                } else {
                    mediator.hideElements(false);
                }
            }
        }
    }
}
