package com.springboot.mongodb.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mongodb.restapi.model.Card;
import com.springboot.mongodb.restapi.repository.CardRepository;

@Service
public class CardService {
	
	@Autowired
	private CardRepository repository;
	
	public Card addCard(Card card){
		return repository.save(card);
	}
	
	public List<Card> getCards(){
		List<Card> cards = repository.findAll();
		return cards;
	}
	
	public Card getCardbyNumber(String cardNumber){
		return repository.findOne(cardNumber);
	}
}
