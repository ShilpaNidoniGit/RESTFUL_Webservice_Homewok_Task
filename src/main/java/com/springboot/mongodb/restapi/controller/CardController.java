package com.springboot.mongodb.restapi.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mongodb.restapi.model.Card;
import com.springboot.mongodb.restapi.service.CardService;
import com.springboot.mongodb.restapi.utility.SpringBootMongodbRestApiUtility;

@RestController
@RequestMapping("/rest/card")
public class CardController {

	@Autowired
	CardService service;
	
	@PostMapping(path = "/allCardProperties/create", consumes = "application/json")
	public String create(@RequestBody Card newCard){
		if(!StringUtils.isEmpty(service.getCardbyNumber(newCard.getCardNumber())))
				return "The card with " + newCard.getCardNumber() + " number already exists! Please specify different card number!";
		service.addCard(newCard);
		return "The card with number " + newCard.getCardNumber() + " created successfully";
	}

	@PostMapping(path = "/specificCardProperties/create", consumes = "application/json")
	public String create(
			@RequestParam(value = "cardSchema", required = false, defaultValue = "VISA") String cardSchema,
			@RequestParam(value = "cardHolderName", required = true) String cardHolderName,
			@RequestParam(value = "amount", required = false, defaultValue = "1") BigInteger amount){
		Card newCard = new Card(SpringBootMongodbRestApiUtility.generateCardNumber(), cardSchema,
				SpringBootMongodbRestApiUtility.generateValidityDate(), cardHolderName,
				SpringBootMongodbRestApiUtility.generateTransaction(amount));
		service.addCard(newCard);
		return "The card with number " + newCard.getCardNumber() + " created successfully for the user " + cardHolderName;
	}
	
	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Card> getAll() {
		return service.getCards();
	}

	@GetMapping(path = "/getCardByNumber/{cardNumber}", produces = "application/json")
	public Card getCard(@PathVariable("cardNumber") String cardNumber) {
		return service.getCardbyNumber(cardNumber);
	}
}
