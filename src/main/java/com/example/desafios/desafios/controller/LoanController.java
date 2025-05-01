package com.example.desafios.desafios.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafios.desafios.dto.CustomerDto;
import com.example.desafios.desafios.dto.ReturnDto;
import com.example.desafios.desafios.service.CustomerLoanService;

@RestController
@RequestMapping("/customer-loans")
public class LoanController {

  private static CustomerLoanService customerLoanService;

  LoanController(CustomerLoanService customerLoanService) {
    this.customerLoanService = customerLoanService;
  }

  @PostMapping()
  public ResponseEntity<ReturnDto> customerLoans(
      @RequestBody CustomerDto requestBody) {
      
      var returnDto = customerLoanService.customerLoans(requestBody);

    return ResponseEntity.ok().body(returnDto);
  }

}
