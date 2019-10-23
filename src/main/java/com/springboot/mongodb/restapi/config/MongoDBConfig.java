package com.springboot.mongodb.restapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.springboot.mongodb.restapi.repository.CardRepository;

@EnableMongoRepositories(basePackageClasses = CardRepository.class)
@Configuration
public class MongoDBConfig {
	

}
