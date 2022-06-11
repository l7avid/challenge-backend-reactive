package com.sofka.challengebackend.repository;

import com.sofka.challengebackend.collections.Receipt;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReceiptRepository extends ReactiveMongoRepository<Receipt, String> {
}
