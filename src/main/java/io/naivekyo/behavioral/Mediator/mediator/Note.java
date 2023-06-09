package io.naivekyo.behavioral.Mediator.mediator;

public class Note {
    
    private String name;
    
    private String text;

    public Note() {
        this.name = "New note";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
