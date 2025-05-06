package com.example.desafios.desafios.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

  public boolean isValid(String auth) {
    return auth.equals("Bearer 1234567890");
  }
}
