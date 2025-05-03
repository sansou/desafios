package com.example.desafios.desafios.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.desafios.desafios.entity.PointOfInterest;

@Component
public class PointOfInterestValidation implements Validator{
  @Override
  public boolean supports(Class<?> clazz) {
    return PointOfInterest.class.equals(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    PointOfInterest poi = (PointOfInterest) target;
    if (poi.getName() == null || poi.getName().isEmpty()) {
      errors.rejectValue("Name", "name.empty", "Name não pode ser vazio.");
    }
    if (poi.getxAxis() < 0 ) {
      errors.rejectValue("xAxis", "axis.negative", "xAxis não pode ser menor que zero" );
    }
    if (poi.getyAxis() < 0 ) {
      errors.rejectValue("yAxis", "axis.negative", "yAxis não pode ser menor que zero" );
    }
  }

}
