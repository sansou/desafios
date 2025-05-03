package com.example.desafios.desafios.dto;

import java.util.List;

public record ReturnLoanDto(String customer, List<LoanDto> loans) {
    
}
