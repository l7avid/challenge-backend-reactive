package com.sofka.challengebackend.routes;

import com.sofka.challengebackend.usecases.GetPurveyorsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class GetPurveyorsRoute {

    @Bean
    public RouterFunction<ServerResponse> allPurveyors(GetPurveyorsUseCase getPurveyorsUseCase){

    }
}
