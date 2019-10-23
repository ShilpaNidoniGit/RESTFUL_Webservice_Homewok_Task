package com.springboot.mongodb.restapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.mongodb.restapi.model.Card;

public interface CardRepository extends MongoRepository<Card, String> {
}
