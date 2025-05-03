package com.example.desafios.desafios.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafios.desafios.dto.PointOfInterestCreatedEvent;
import com.example.desafios.desafios.service.PointOfInterestService;

@RestController
@RequestMapping("/points-of-interest")
public class PointOfInterestController {
  
  private final PointOfInterestService pointOfInterestService;

  public PointOfInterestController(PointOfInterestService pointOfInterestService) {
    this.pointOfInterestService = pointOfInterestService;
  }

  @PostMapping()
  public ResponseEntity<?> addPointOfInterest(
    @RequestBody PointOfInterestCreatedEvent pointOfInterestCreatedEvent
  ) {
    // Call the service method to add a point of interest
    var erros = pointOfInterestService.save(pointOfInterestCreatedEvent);
    //TODO: capturar os erros e retornar o erro correto para o cliente
    if (erros != null && erros.hasErrors()) {
      System.out.println(erros.getFieldErrors());
      return ResponseEntity.badRequest().body(erros.getFieldErrors());
    }
    
    return ResponseEntity.created(null).body(null);
  }

}
