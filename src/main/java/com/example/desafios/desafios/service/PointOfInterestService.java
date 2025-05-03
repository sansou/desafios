package com.example.desafios.desafios.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.example.desafios.desafios.dto.PointOfInterestCreatedEvent;
import com.example.desafios.desafios.entity.PointOfInterest;
import com.example.desafios.desafios.repository.PointOfInterestRepository;
import com.example.desafios.desafios.validation.PointOfInterestValidation;

@Service
public class PointOfInterestService {

  private final PointOfInterestRepository pointOfInterestRepository;
  private final PointOfInterestValidation pointOfInterestValidation;

  public PointOfInterestService(PointOfInterestRepository pointOfInterestRepository) {
    this.pointOfInterestRepository = pointOfInterestRepository;
    this.pointOfInterestValidation = new PointOfInterestValidation();
  }

  public Errors save(PointOfInterestCreatedEvent poiEvent){
    PointOfInterest poi = mapToEntity(poiEvent);
    Errors erros = null;
    pointOfInterestValidation.validate(poi, erros);
    pointOfInterestRepository.save(poi);
    return erros ;
  }

  private PointOfInterest mapToEntity(PointOfInterestCreatedEvent poiEvent) {
    return new PointOfInterest(null, poiEvent.name(), poiEvent.xAxis(), poiEvent.yAxis());
  }
}
