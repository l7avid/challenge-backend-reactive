package com.sofka.challengebackend.usecases;

import com.sofka.challengebackend.DTO.PurveyorDTO;
import com.sofka.challengebackend.mapper.PurveyorMapper;
import com.sofka.challengebackend.repository.IPurveyorRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreatePurveyorUseCase {

    private final IPurveyorRepository repository;
    private final PurveyorMapper mapper;

    public CreatePurveyorUseCase(IPurveyorRepository repository, PurveyorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    private boolean validateAttributes(PurveyorDTO purveyorDTO){
        return purveyorDTO.getPurveyorName() != null &&
                purveyorDTO.getPurveyorEmail() != null &&
                purveyorDTO.getPurveyorIdentification() != null;
    }

    private Mono<PurveyorDTO> validatePurveyorDTO(PurveyorDTO purveyorDTO){
        return Mono.just(purveyorDTO)
                .filter(purveyorDTO1 -> this.validateAttributes(purveyorDTO1))
                .switchIfEmpty(Mono.error(() -> new Exception("Missing Attributes")));
    }

    public Mono<PurveyorDTO> createPurveyor(PurveyorDTO purveyorDTO){
        return validatePurveyorDTO(purveyorDTO)
                .flatMap(purveyorDTO1 -> repository.save(mapper.toPurveyor(purveyorDTO1)))
                .map(purveyor -> mapper.toPurveyorDTO(purveyor));
    }
}
