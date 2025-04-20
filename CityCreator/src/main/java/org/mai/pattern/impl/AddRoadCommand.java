package org.mai.pattern.impl;

import lombok.AllArgsConstructor;
import org.mai.model.MapGraph;
import org.mai.pattern.interfaces.Command;

@AllArgsConstructor
public class AddRoadCommand implements Command {
    private MapGraph graph;
    private String from;
    private String to;
    private int cost;


    @Override
    public void execute() {
        graph.addRoadToMap(from, to, cost);
    }

    @Override
    public void undo() {
        graph.deleteRoadFromMap(from, to, cost);
    }

    @Override
    public void redo() {
        graph.addRoadToMap(from, to, cost);
    }
}
