package org.mai.pattern.impl;

import org.mai.pattern.EventAggregator;
import org.mai.pattern.Observer;

import java.util.ArrayList;
import java.util.List;

public class AggregatorImpl implements EventAggregator {
    private List<Observer> observers;

    public AggregatorImpl() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String data) {
        for (Observer o : observers) {
            o.dataChangeNotify(data);
        }
    }
}
