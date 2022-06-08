package com.sofka.challengebackend.usecases;

import com.sofka.challengebackend.DTO.PurveyorDTO;
import com.sofka.challengebackend.mapper.PurveyorMapper;
import com.sofka.challengebackend.repository.IPurveyorRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetPurveyorsUseCase {

    private final IPurveyorRepository repository;
    private final PurveyorMapper mapper;


    public GetPurveyorsUseCase(IPurveyorRepository repository, PurveyorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Flux<PurveyorDTO> getAllPurveyors(){
        return repository.findAll().map(purveyor -> mapper.toPurveyorDTO(purveyor));
    }
}
