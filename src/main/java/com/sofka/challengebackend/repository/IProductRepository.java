package com.sofka.challengebackend.repository;

import com.sofka.challengebackend.collections.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends ReactiveMongoRepository<Product, String> {

}
