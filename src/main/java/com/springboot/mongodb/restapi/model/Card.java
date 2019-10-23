package com.springboot.mongodb.restapi.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cards")
public class Card {
		
	@Id
	private String cardNumber;
	
	private String cardSchema;
	
	private String validityDate;
	
	private String cardHolderName;
	
	private List<Transaction> transactions;
	
	public Card() {
    }

	public Card(String cardNumber, String cardSchema, String validityDate,
			String cardHolderName, List<Transaction> transactions) {
		this.cardNumber = cardNumber;
		this.cardSchema = cardSchema;
		this.validityDate = validityDate;
		this.cardHolderName = cardHolderName;
		this.transactions = transactions;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardSchema() {
		return cardSchema;
	}

	public void setCardSchema(String cardSchema) {
		this.cardSchema = cardSchema;
	}

	public String getValidityDate() {
		return validityDate;
	}

	public void setValidityDate(String validityDate) {
		this.validityDate = validityDate;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "CardModel [cardNumber=" + cardNumber + ", cardSchema=" + cardSchema + ", date=" + validityDate + ", cardHolderName=" + cardHolderName + ", transactions count="
				+ transactions.size() + "]";
	}
	
}
