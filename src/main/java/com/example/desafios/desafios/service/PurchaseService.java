package com.example.desafios.desafios.service;

import org.springframework.stereotype.Service;

import com.example.desafios.desafios.dto.PurchaseDto;
import com.example.desafios.desafios.entity.Purchase;
import com.example.desafios.desafios.repository.PurchaseRepository;

@Service
public class PurchaseService {
	private final PurchaseRepository purchaseRepository;

	public PurchaseService(PurchaseRepository purchaseRepository) {
		this.purchaseRepository = purchaseRepository;
	}

	public Purchase create (PurchaseDto entityDto) {
		var entity = new Purchase();
		entity.setUserDocument(entityDto.userDocument());
		entity.setCreditCardToken(entityDto.creditCardToken());
		entity.setValue(entityDto.value());
		return purchaseRepository.save(entity);
	}
}
