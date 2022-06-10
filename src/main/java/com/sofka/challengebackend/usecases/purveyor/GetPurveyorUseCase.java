package com.sofka.challengebackend.usecases.purveyor;

import com.sofka.challengebackend.DTO.PurveyorDTO;
import com.sofka.challengebackend.mapper.PurveyorMapper;
import com.sofka.challengebackend.repository.IPurveyorRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GetPurveyorUseCase {

    private final IPurveyorRepository repository;
    private final PurveyorMapper mapper;

    public GetPurveyorUseCase(IPurveyorRepository repository, PurveyorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Mono<PurveyorDTO> getPurveyor(String purveyorName){
        return repository.findBypurveyorName(purveyorName).map(purveyor -> mapper.toPurveyorDTO(purveyor))
                .switchIfEmpty(Mono.error(() -> new Exception("Not able to find a purveyor with the given name")));
    }
}
