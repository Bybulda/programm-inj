package org.mai.exception;

public class CityNotFoundException extends RuntimeException {
    private final String city;
    public CityNotFoundException(String city) {
        this.city = city;
    }

    @Override
    public String getMessage() {
        return "City not found: " + city;
    }
}
