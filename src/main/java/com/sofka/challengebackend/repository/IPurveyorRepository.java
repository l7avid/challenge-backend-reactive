package com.sofka.challengebackend.repository;

import com.sofka.challengebackend.collections.Purveyor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPurveyorRepository extends ReactiveMongoRepository<Purveyor, String> {
}
