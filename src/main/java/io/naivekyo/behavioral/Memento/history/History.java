package io.naivekyo.behavioral.Memento.history;

import io.naivekyo.behavioral.Memento.commands.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NaiveKyo
 * @version 1.0
 * @since 2023/5/30 22:01
 */
public class History {
    
    private List<Pair> history = new ArrayList<>();
    
    private int virtualSize = 0;

    public void push(Command c, Memento m) {
        if (virtualSize != history.size() && virtualSize > 0) {
            history = history.subList(0, virtualSize - 1);
        }
        history.add(new Pair(c, m));
        virtualSize = history.size();
    }

    public boolean undo() {
        Pair pair = getUndo();
        if (pair == null) {
            return false;
        }
        System.out.println("Undoing: " + pair.getCommand().getName());
        pair.getMemento().restore();
        return true;
    }

    public boolean redo() {
        Pair pair = getRedo();
        if (pair == null) {
            return false;
        }
        System.out.println("Redoing: " + pair.getCommand().getName());
        pair.getMemento().restore();
        pair.getCommand().execute();
        return true;
    }

    private Pair getUndo() {
        if (virtualSize == 0) {
            return null;
        }
        virtualSize = Math.max(0, virtualSize - 1);
        return history.get(virtualSize);
    }

    private Pair getRedo() {
        if (virtualSize == history.size()) {
            return null;
        }
        virtualSize = Math.min(history.size(), virtualSize + 1);
        return history.get(virtualSize - 1);
    }
    
    private class Pair {
        
        Command command;
        
        Memento memento;

        public Pair(Command command, Memento memento) {
            this.command = command;
            this.memento = memento;
        }

        public Command getCommand() {
            return command;
        }

        public Memento getMemento() {
            return memento;
        }
    }
}
