package org.mai.pattern.impl;

import lombok.AllArgsConstructor;
import org.mai.model.MapGraph;
import org.mai.pattern.interfaces.Command;

@AllArgsConstructor
public class AddCityCommand implements Command {
    private MapGraph graph;
    private String cityName;
    private int x;
    private int y;

    @Override
    public void execute() {
        graph.addCityToMap(cityName, x, y);
    }

    @Override
    public void undo() {
        graph.deleteCityFromMap(cityName);
    }

    @Override
    public void redo() {
        graph.addCityToMap(cityName, x, y);
    }
}
