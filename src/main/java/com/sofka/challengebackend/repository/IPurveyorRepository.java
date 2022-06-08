package com.sofka.challengebackend.repository;

import com.sofka.challengebackend.DTO.PurveyorDTO;
import com.sofka.challengebackend.collections.Purveyor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface IPurveyorRepository extends ReactiveMongoRepository<Purveyor, String> {

    Mono<Purveyor> findBypurveyorName(String purveyorName);
}
