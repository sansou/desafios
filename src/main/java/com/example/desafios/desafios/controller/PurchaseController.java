package com.example.desafios.desafios.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.desafios.desafios.dto.PurchaseDto;
import com.example.desafios.desafios.entity.Purchase;
import com.example.desafios.desafios.service.PurchaseService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	private final PurchaseService purchaseService;

	public PurchaseController(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}

	@PostMapping()
	public ResponseEntity<Purchase> create(@RequestBody PurchaseDto entityDto) {
		var entity = purchaseService.create(entityDto);
		return ResponseEntity.created(null).body(entity);
	}

}
