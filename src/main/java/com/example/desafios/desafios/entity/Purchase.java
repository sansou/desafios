package com.example.desafios.desafios.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.example.desafios.utils.cryptography.MongoAesEncryptionUtil;

@Document(collection = "purchase")
public class Purchase {
	@MongoId
	private String id;

	//salvo criptografado no banco de dados
	private String userDocument;
	
	//salvo criptografado no banco de dados
	private String creditCardToken;
	

	@Field(targetType =  FieldType.INT64)
	private Long value;
	
	public Purchase() {
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getUserDocument() {
		return userDocument  != null ? MongoAesEncryptionUtil.decrypt(userDocument) : null;
	}
	public void setUserDocument(String userDocument) {
		this.userDocument = userDocument != null ? MongoAesEncryptionUtil.encrypt(userDocument) : null;
	}
	public String getCreditCardToken() {
		return creditCardToken != null ? MongoAesEncryptionUtil.decrypt(creditCardToken) : null;
	}
	public void setCreditCardToken(String creditCardToken) {
		this.creditCardToken = creditCardToken != null ? MongoAesEncryptionUtil.encrypt(creditCardToken) : null;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}



}
