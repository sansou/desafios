package com.example.desafios.desafios.dto;

import java.util.List;

public record ReturnDto(String customer, List<LoanDto> loans) {
    
}
