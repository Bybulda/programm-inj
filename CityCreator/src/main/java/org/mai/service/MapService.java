package org.mai.service;

import lombok.NoArgsConstructor;
import org.mai.model.HistoryManager;
import org.mai.model.MapGraph;
import org.mai.pattern.impl.*;
import org.mai.pattern.interfaces.Command;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class MapService {

    private final MapGraph mapGraph = new MapGraph();
    private final HistoryManager manager = new HistoryManager();

    public void addCity(String city) {
        Command addCity = new AddCityCommand(mapGraph, city);
        manager.execute(addCity);
    }

    public void deleteCity(String city) {
        Command deleteCity = new DeleteCityCommand(mapGraph, city);
        manager.execute(deleteCity);
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
