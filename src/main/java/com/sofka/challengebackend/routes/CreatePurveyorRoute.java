package com.sofka.challengebackend.routes;

import com.sofka.challengebackend.DTO.PurveyorDTO;
import com.sofka.challengebackend.usecases.CreatePurveyorUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class CreatePurveyorRoute {

    @Bean
    public RouterFunction<ServerResponse> create(CreatePurveyorUseCase createPurveyorUseCase){
        return route(POST("/create/purveyor").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(PurveyorDTO.class)
                        .flatMap(purveyorDTO -> createPurveyorUseCase.createPurveyor(purveyorDTO))
                        .flatMap(purveyorDTO -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(purveyorDTO))
                        .onErrorResume(e -> ServerResponse.status(HttpStatus.BAD_REQUEST).build()));
    }
}
