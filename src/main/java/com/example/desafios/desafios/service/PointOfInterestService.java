package com.example.desafios.desafios.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import com.example.desafios.desafios.dto.PointOfInterestEvent;
import com.example.desafios.desafios.dto.PointOfInterestRange;
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

  public Errors save(PointOfInterestEvent poiEvent) {
    PointOfInterest poi = mapToEntity(poiEvent);
    Errors erros = new BeanPropertyBindingResult(poi, "Point Of Interest") ;
    pointOfInterestValidation.validate(poi, erros);
    pointOfInterestRepository.save(poi);
    return erros;
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

  public List<PointOfInterestEvent> listNearPois(PointOfInterestRange poiRange) {
    var result = pointOfInterestRepository.findAll();
    var poisEvent = new ArrayList<PointOfInterestEvent>();

    if (!result.isEmpty()) {
      result.forEach(poi -> {
        if (isWithinRange(poi, poiRange)) {
          poisEvent.add(new PointOfInterestEvent(poi.getName(), poi.getxAxis(), poi.getyAxis()));
        }
      });
    }

    return poisEvent;
  }

  private boolean isWithinRange(PointOfInterest poi, PointOfInterestRange poiRange) {

    double xDiff = Math.pow((poi.getxAxis() - poiRange.xAxis()), 2);
    double yDiff = Math.pow((poi.getyAxis() - poiRange.yAxis()), 2);

    Double distance = Math.sqrt(xDiff + yDiff);
    return distance <= poiRange.range();
  }
}
