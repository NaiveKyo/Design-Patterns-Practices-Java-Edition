package io.naivekyo.behavioral.Memento.commands;

/**
 * 基础命令接口
 */
public interface Command {
    
    String getName();
    
    void execute();
    
}
