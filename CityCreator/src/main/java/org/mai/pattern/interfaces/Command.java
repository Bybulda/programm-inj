package org.mai.pattern.interfaces;

public interface Command {
    void execute();
    void undo();
    void redo();
}
