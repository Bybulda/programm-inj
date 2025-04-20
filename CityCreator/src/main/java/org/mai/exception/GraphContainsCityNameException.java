package org.mai.exception;

public class GraphContainsCityNameException extends RuntimeException {
    private String cityName;

    public GraphContainsCityNameException(String city) {
        super(city);
        cityName = city;
    }
    @Override
    public String getMessage() {
        return "Graph already contains this city name " + cityName;
    }
}
