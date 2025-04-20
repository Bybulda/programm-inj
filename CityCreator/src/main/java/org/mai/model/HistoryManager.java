package org.mai.model;

import lombok.NoArgsConstructor;
import org.mai.pattern.interfaces.Command;

import java.util.ArrayDeque;
import java.util.Deque;


@NoArgsConstructor
public class HistoryManager {
    private final Deque<Command> undo = new ArrayDeque<>();
    private final Deque<Command> redo = new ArrayDeque<>();

    public void execute(Command command) {
        command.execute();
        undo.push(command);
        redo.clear();
    }

    public void undo() {
        if(!undo.isEmpty()){
            Command command = undo.pop();
            command.undo();
            redo.push(command);
        }
    }

    public void redo() {
        if(!redo.isEmpty()){
            Command command = redo.pop();
            command.redo();
            undo.push(command);
        }
    }
}
