package com.sofka.challengebackend.mapper;

import com.sofka.challengebackend.DTO.PurveyorDTO;
import com.sofka.challengebackend.collections.Purveyor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class PurveyorMapper {

    private final ModelMapper mapper;

    public PurveyorMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public PurveyorDTO toPurveyorDTO(Purveyor purveyor){
        return mapper.map(purveyor, PurveyorDTO.class);
    }

    public Purveyor toPurveyor(PurveyorDTO purveyorDTO){
        return mapper.map(purveyorDTO, Purveyor.class);
    }
}
