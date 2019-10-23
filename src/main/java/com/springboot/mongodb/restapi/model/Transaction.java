package com.springboot.mongodb.restapi.model;



import java.math.BigInteger;

public class Transaction {
	
    private String date;
 
    private BigInteger amount;

    public Transaction(){
	}
    
	public Transaction(String date, BigInteger amount){
		this.date = date;
		this.amount = amount;	
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public BigInteger getAmount() {
		return amount;
	}

	public void setAmount(BigInteger amount) {
		this.amount = amount;
	}
    
}
