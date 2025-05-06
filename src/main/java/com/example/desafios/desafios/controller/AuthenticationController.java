package com.example.desafios.desafios.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.desafios.desafios.service.AuthenticationService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
public class AuthenticationController {
  private final AuthenticationService authenticationService;

  public AuthenticationController(AuthenticationService authenticationService) {
    this.authenticationService = authenticationService;
  }

  @GetMapping("/foo-bar")
  public ResponseEntity<?> authentication(@RequestHeader("Authorization") String auth) {
    if (authenticationService.isValid(auth)) {
      return ResponseEntity.status(204).body(null);
    } else {
      return ResponseEntity.status(401).body("Unauthorized");
    }
  }

}
