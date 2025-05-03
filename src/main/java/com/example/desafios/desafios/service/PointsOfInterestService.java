package com.example.desafios.desafios.service;

import org.springframework.stereotype.Service;

import com.example.desafios.desafios.dto.PointOfInterestCreatedEvent;
import com.example.desafios.desafios.entity.PointOfInterest;
import com.example.desafios.desafios.repository.PointOfInterestRepository;

@Service
public class PointsOfInterestService {

  private final PointOfInterestRepository pointOfInterestRepository;

  public PointsOfInterestService(PointOfInterestRepository pointOfInterestRepository) {
    this.pointOfInterestRepository = pointOfInterestRepository;
  }

  public void save(PointOfInterestCreatedEvent poiEvent){
    PointOfInterest poi = mapToEntity(poiEvent);
    pointOfInterestRepository.save(poi);
  }

  private PointOfInterest mapToEntity(PointOfInterestCreatedEvent poiEvent) {
    return new PointOfInterest(null, poiEvent.name(), poiEvent.xAxis(), poiEvent.yAxis());
  }
}
