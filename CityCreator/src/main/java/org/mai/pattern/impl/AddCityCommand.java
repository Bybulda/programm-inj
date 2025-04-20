package org.mai.pattern.impl;

import lombok.AllArgsConstructor;
import org.mai.model.MapGraph;
import org.mai.pattern.interfaces.Command;

@AllArgsConstructor
public class AddCityCommand implements Command {
    private MapGraph graph;
    private String cityName;

    @Override
    public void execute() {
        graph.addCityToMap(cityName);
    }

    @Override
    public void undo() {
        graph.deleteCityFromMap(cityName);
    }

    @Override
    public void redo() {
        graph.addCityToMap(cityName);
    }
}
