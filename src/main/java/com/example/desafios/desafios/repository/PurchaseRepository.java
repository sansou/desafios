package com.example.desafios.desafios.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.desafios.desafios.entity.Purchase;

public interface PurchaseRepository  extends MongoRepository<Purchase, String> {

	Purchase findByUserDocument(String userDocument);
	Purchase findByCreditCardToken(String creditCardToken);

}