package io.naivekyo.behavioral.Mediator.mediator;

import io.naivekyo.behavioral.Mediator.components.Component;

import javax.swing.*;

/**
 * Mediator 公共接口
 */
public interface Mediator {
    
    void addNewNote(Note note);
    
    void deleteNote();
    
    void getInfoFromList(Note note);
    
    void saveChanges();
    
    void markNote();
    
    void clear();
    
    void sendToFilter(ListModel listModel);
    
    void setElementsList(ListModel list);
    
    void registerComponent(Component component);
    
    void hideElements(boolean flag);
    
    void createGUI();
    
}
