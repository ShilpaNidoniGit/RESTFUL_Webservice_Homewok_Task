package com.springboot.mongodb.restapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.mongodb.restapi.model.Card;
import com.springboot.mongodb.restapi.model.Transaction;
import com.springboot.mongodb.restapi.repository.CardRepository;
import com.springboot.mongodb.restapi.service.CardService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMongodbRestApiApplicationTests {

	@Autowired
	private CardService service;
	
	@MockBean
	private CardRepository repository;

	@Test
	public void getCardsTest(){
		when(repository.findAll()).thenReturn(
				Stream.of(
						new Card("1239687184001016", "AMEX", "10/2024",
								"Shilpa",
								Arrays.asList(new Transaction("22/10/2019",
										BigInteger.valueOf(40000)))),
						new Card("4562798876537894", "VISA", "10/2024",
								"Alexa",
								Arrays.asList(new Transaction("22/10/2019",
										BigInteger.valueOf(50000))))).collect(
						Collectors.toList()));
		assertEquals(2, service.getCards().size());
	}
	
	@Test
	public void getCardbyNumberTest(){
		String cardNumber = "8769687184001017";
		when(repository.findOne(cardNumber)).thenReturn(
						new Card("8769687184001017", "VISA", "10/2024",
								"Shilpa",
								Arrays.asList(new Transaction("22/10/2019",
										BigInteger.valueOf(40000)))));
		assertSame("Card numbers are equal", cardNumber, service.getCardbyNumber(cardNumber).getCardNumber());
	}

	@Test
	public void addCardTest(){
		Card card = new Card("4569687184001016", "AMEX", "10/2024", "Shilpa",
				Arrays.asList(new Transaction("22/10/2019", BigInteger.valueOf(40000))));
		when(repository.save(card)).thenReturn(card);
		assertEquals(card, service.addCard(card));
	}
}

