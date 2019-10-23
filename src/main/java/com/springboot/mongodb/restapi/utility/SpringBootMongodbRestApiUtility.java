package com.springboot.mongodb.restapi.utility;

import java.math.BigInteger;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

import com.springboot.mongodb.restapi.model.Transaction;

public class SpringBootMongodbRestApiUtility {

	public static String generateCardNumber() {
		Random random = new Random(System.currentTimeMillis());
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 16; i++) {
			int digit = random.nextInt(10);
			builder.append(digit);
		}
		return builder.toString();
	}

	public static String generateValidityDate() {
		Calendar date = Calendar.getInstance();
		date.setTime(new Date());
		Format f = new SimpleDateFormat("MM/YYYY");
		date.add(Calendar.YEAR, 5);
		return f.format(date.getTime());
	}

	public static List<Transaction> generateTransaction(BigInteger amount) {
		Format f = new SimpleDateFormat("dd/MM/YYYY");
		f.format(new Date().getTime());
		Transaction newTxn = new Transaction();
		newTxn.setDate(f.format(new Date().getTime()));
		newTxn.setAmount(amount);
		return Arrays.asList(newTxn);
	}
}
