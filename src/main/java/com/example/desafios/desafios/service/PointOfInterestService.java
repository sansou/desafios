package com.example.desafios.desafios.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.example.desafios.desafios.dto.PointOfInterestEvent;
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

  public Errors save(PointOfInterestEvent poiEvent){
    PointOfInterest poi = mapToEntity(poiEvent);
    Errors erros = null;
    pointOfInterestValidation.validate(poi, erros);
    pointOfInterestRepository.save(poi);
    return erros ;
  }

  private PointOfInterest mapToEntity(PointOfInterestEvent poiEvent) {
    return new PointOfInterest(null, poiEvent.name(), poiEvent.xAxis(), poiEvent.yAxis());
  }

  public List<PointOfInterestEvent> getAllPointsOfInterest() {
    return pointOfInterestRepository.findAll()
      .stream()
      .map(poi -> new PointOfInterestEvent(poi.getName(), poi.getxAxis(), poi.getyAxis()))
      .toList();
  }
}
