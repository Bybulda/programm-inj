package org.mai.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapGraph {
    private HashMap<String, City> graph = new HashMap<>();
    private List<Road> roads = new ArrayList<>();

    public void addCityToMap(String name){
        graph.put(name, new City(name));
    }

    public void deleteCityFromMap(String name){
        graph.remove(name);
    }

    public void changeCityName(String oldName, String newName){

    }

    public void addRoadToMap(String from, String to, int cost){
        roads.add(new Road(from, to, cost));
    }

    public void deleteRoadFromMap(String from, String to, int cost){
        roads.remove(new Road(from, to, cost));
    }
}
