package org.mai.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mai.model.City;
import org.mai.model.HistoryManager;
import org.mai.model.MapGraph;
import org.mai.pattern.impl.*;
import org.mai.pattern.interfaces.Command;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class MapService {

    @Getter
    private final MapGraph mapGraph = new MapGraph();
    private final HistoryManager manager = new HistoryManager();

    public void addCity(String city, int x, int y) {
        Command addCity = new AddCityCommand(mapGraph, city, x, y);
        manager.execute(addCity);
    }

    public void deleteCity(String city, int x, int y) {
        City cityG = mapGraph.getGraph().getOrDefault(city, null);
        if (cityG != null) {
            x = cityG.getX();
            y = cityG.getY();
            Command deleteCity = new DeleteCityCommand(mapGraph, city, x, y);
            manager.execute(deleteCity);
        }
    }

    public void changeCityName(String oldName, String newName) {
        Command changeCity = new ChangeCityNameCommand(mapGraph, oldName, newName);
        manager.execute(changeCity);
    }

    public void addRoad(String from, String to, int cost){
        Command addRoad = new AddRoadCommand(mapGraph, from, to, cost);
        manager.execute(addRoad);
    }

    public void deleteRoad(String from, String to, int cost){
        Command deleteRoad = new DeleteRoadCommand(mapGraph, from, to, cost);
        manager.execute(deleteRoad);
    }

    public void changeRoadCost(String from, String to, int oldCost, int newCost){
        Command changeCost = new ChangeRoadCommand(mapGraph, from, to, oldCost, newCost);
        manager.execute(changeCost);
    }

    public void undo(){
        manager.undo();
    }

    public void redo(){
        manager.redo();
    }

}
