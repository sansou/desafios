package com.example.desafios.desafios.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafios.desafios.dto.PointOfInterestEvent;
import com.example.desafios.desafios.dto.PointOfInterestRange;
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
      @RequestBody PointOfInterestEvent pointOfInterestCreatedEvent) {
    var erros = pointOfInterestService.save(pointOfInterestCreatedEvent);
    if (erros != null && erros.hasErrors()) {
      return ResponseEntity.badRequest().body(erros.getFieldErrors());
    }

    return ResponseEntity.created(null).body(null);
  }

  @GetMapping("/list")
  public ResponseEntity<List<PointOfInterestEvent>> getAllPointsOfInterest() {
    var pointsOfInterest = pointOfInterestService.getAllPointsOfInterest();
    return ResponseEntity.ok(pointsOfInterest);
  }

  @PostMapping("/near")
  public ResponseEntity<?> getPointOfInterestByName(@RequestBody PointOfInterestRange range) {
    var returned = pointOfInterestService.listNearPois(range);
    System.out.println(returned);

    return ResponseEntity.ok().body(returned);
  }

  @GetMapping("/{name}")
  public ResponseEntity<String> getPointOfInterestByName(@PathVariable String name) {
    // Call the service method to get a point of interest by name
    // var pointOfInterest = pointOfInterestService.getPointOfInterestByName(name);
    return ResponseEntity.ok().body(name);
  }

}
