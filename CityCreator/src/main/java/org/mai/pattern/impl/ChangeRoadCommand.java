package org.mai.pattern.impl;

import lombok.AllArgsConstructor;
import org.mai.model.MapGraph;
import org.mai.pattern.interfaces.Command;

@AllArgsConstructor
public class ChangeRoadCommand implements Command {
    private MapGraph graph;
    private String from;
    private String to;
    private int oldCost;
    private int newCost;


    @Override
    public void execute() {
        graph.changeRoadCost(from, to, oldCost, newCost);
    }

    @Override
    public void undo() {
        graph.changeRoadCost(from, to, newCost, oldCost);
    }

    @Override
    public void redo() {
        graph.changeRoadCost(from, to, oldCost, newCost);
    }
}
