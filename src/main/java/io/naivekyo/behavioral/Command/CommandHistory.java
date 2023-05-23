package io.naivekyo.behavioral.Command;

import java.util.LinkedList;

public class CommandHistory {
    
    private LinkedList<Command> history = new LinkedList<>();
    
    public void push(Command c) {
        this.history.push(c);
    }
    
    public Command pop() {
        return this.history.pop();
    }
    
    public boolean isEmpty() {
        return this.history.isEmpty();
    }
    
}
