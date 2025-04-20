package org.mai.pattern.impl;

import lombok.AllArgsConstructor;
import org.mai.model.MapGraph;
import org.mai.pattern.interfaces.Command;

@AllArgsConstructor
public class DeleteRoadCommand implements Command {
    private MapGraph graph;
    private String from;
    private String to;
    private int cost;

    @Override
    public void execute() {
        graph.deleteRoadFromMap(from, to, cost);
    }

    @Override
    public void undo() {
        graph.addRoadToMap(from, to, cost);
    }

    @Override
    public void redo() {
        graph.deleteRoadFromMap(from, to, cost);
    }
}
