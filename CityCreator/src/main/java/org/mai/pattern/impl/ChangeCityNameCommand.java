package org.mai.pattern.impl;


import lombok.AllArgsConstructor;
import org.mai.model.MapGraph;
import org.mai.pattern.interfaces.Command;

@AllArgsConstructor
public class ChangeCityNameCommand implements Command {
    private MapGraph graph;
    private String oldName;
    private String newName;

    @Override
    public void execute() {
        graph.changeCityName(oldName, newName);
    }

    @Override
    public void undo() {
        graph.changeCityName(newName, oldName);
    }

    @Override
    public void redo() {
        graph.changeCityName(oldName, newName);
    }
}
