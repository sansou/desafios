package com.example.desafios.desafios.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.desafios.desafios.entity.PointOfInterest;

public interface PointOfInterestRepository extends MongoRepository<PointOfInterest, Long> {
    // Custom query methods can be defined here if needed
    // For example, find by name or coordinates
    PointOfInterest findByName(String name);
    PointOfInterest findByxAxisAndyAxis(Integer xAxis, Integer yAxis);


}
