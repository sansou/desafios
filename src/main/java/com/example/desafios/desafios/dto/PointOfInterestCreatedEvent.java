package com.example.desafios.desafios.dto;

public record PointOfInterestCreatedEvent(String name, Integer xAxis, Integer yAxis) {
    // This record will automatically generate getters for the fields
    // and a constructor that takes all fields as parameters.
    // You can add additional methods if needed.

}
