package org.mai.pattern.impl;

import lombok.AllArgsConstructor;
import org.mai.model.MapGraph;
import org.mai.pattern.interfaces.Command;

@AllArgsConstructor
public class DeleteCityCommand implements Command {
    private MapGraph graph;
    private String cityName;


    @Override
    public void execute() {
        graph.deleteCityFromMap(cityName);
    }

    @Override
    public void undo() {
        graph.addCityToMap(cityName);
    }

    @Override
    public void redo() {
        graph.deleteCityFromMap(cityName);
    }
}
