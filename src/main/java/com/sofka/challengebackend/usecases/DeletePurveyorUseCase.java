package com.sofka.challengebackend.usecases;

import com.sofka.challengebackend.collections.Purveyor;
import com.sofka.challengebackend.repository.IPurveyorRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeletePurveyorUseCase {

    private final IPurveyorRepository repository;

    public DeletePurveyorUseCase(IPurveyorRepository repository) {
        this.repository = repository;
    }

    private Mono<Purveyor> findPurveyorById(String id){
        return repository.findById(id)
                .switchIfEmpty(Mono.error(() -> new Throwable("Not able to find a Purveyor with the provided id")));
    }

    public Mono<Void> deletePurveyorById(String id){
        return findPurveyorById(id)
                .flatMap(purveyor -> repository.deleteById(purveyor.getPurveyorId()));
    }
}
