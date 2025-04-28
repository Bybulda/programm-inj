package org.mai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mai.exception.CityNotFoundException;
import org.mai.exception.GraphContainsCityNameException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MapGraph {
    private HashMap<String, City> graph = new HashMap<>();
    private List<Road> roads = new ArrayList<>();

    public void addCityToMap(String name, int x, int y){
        if(graph.containsKey(name)){
            throw new GraphContainsCityNameException(name);
        }
        graph.put(name, new City(name, x, y));
    }

    public void deleteCityFromMap(String name){
        graph.remove(name);
        roads.removeIf(road -> road.getFrom().equals(name) || road.getTo().equals(name));
    }

    public void changeCityName(String oldName, String newName){
        if(graph.containsKey(newName)){
            throw new GraphContainsCityNameException(newName);
        }
        if(!graph.containsKey(oldName)){
            throw new CityNotFoundException(oldName);
        }
        City oldCity = graph.remove(oldName);
        oldCity.setName(newName);
        graph.put(newName, oldCity);

        for(Road road : roads){
            if(road.getFrom().equals(oldName)){
                road.setFrom(newName);
            }
            if(road.getTo().equals(oldName)){
                road.setTo(newName);
            }
        }

    }

    public void addRoadToMap(String from, String to, int cost){
        if(!graph.containsKey(from) || !graph.containsKey(to)){
            throw new CityNotFoundException(from + " " + to);
        }
        roads.add(new Road(from, to, cost));
    }

    public void deleteRoadFromMap(String from, String to, int cost){
        roads.removeIf(road -> road.getFrom().equals(from) && road.getTo().equals(to) && road.getCost() == cost);

    }

    public void changeRoadCost(String from, String to, int oldCost, int newCost){
        for(Road road : roads){
            if(road.getFrom().equals(from) && road.getTo().equals(to) && road.getCost() == oldCost){
                road.setCost(newCost);
                return;
            }
        }
        throw new CityNotFoundException(from + " " + to);
    }
}
