package com.sofka.challengebackend.routes.purveyor;

import com.sofka.challengebackend.DTO.PurveyorDTO;
import com.sofka.challengebackend.usecases.purveyor.GetPurveyorsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetPurveyorsRoute {

    @Bean
    public RouterFunction<ServerResponse> allPurveyors(GetPurveyorsUseCase getPurveyorsUseCase){
        return route(GET("/get/purveyors"), request -> ServerResponse.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromProducer(getPurveyorsUseCase.getAllPurveyors(), PurveyorDTO.class)));
    }
}
