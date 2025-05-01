package com.example.desafios.desafios.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.desafios.desafios.dto.CustomerDto;
import com.example.desafios.desafios.dto.LoanDto;
import com.example.desafios.desafios.dto.ReturnDto;

@Service
public class CustomerLoanService {

  public ReturnDto customerLoans(CustomerDto customerDto) {
    List<LoanDto> loans = new ArrayList<>();

    if (customerDto.income() <= 3000) {
      loans.add(new LoanDto("PERSONAL", 4));
    } else if ((customerDto.income() > 3000 && customerDto.income() <= 5000) && customerDto.age() < 30 && customerDto.location().equalsIgnoreCase("sp")) {
      loans.add(new LoanDto("GUARANTEED", 3));
      loans.add(new LoanDto("PERSONAL", 4));
    } else if (customerDto.income() >= 5000 ) {
      loans.add(new LoanDto("CONSIGNMENT", 2));
    } else if (customerDto.income() < 3000) {
      loans.add(new LoanDto("GUARANTEED", 3));
    }

    return new ReturnDto(customerDto.name(), loans);
    
  }
}
