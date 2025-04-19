package org.mai.pattern;

public interface EventAggregator {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String data);
}
