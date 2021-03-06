package com.sofka.challengebackend.routes.purveyor;

import com.sofka.challengebackend.usecases.purveyor.DeletePurveyorUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeletePurveyorRoute {

    @Bean
    public RouterFunction<ServerResponse> deletePurveyor(DeletePurveyorUseCase deletePurveyorUseCase){
        return route(DELETE("/delete/purveyor/{id}"),
                request -> deletePurveyorUseCase.deletePurveyorById(request.pathVariable("id"))
                        .flatMap((unused) -> ServerResponse.status(HttpStatus.ACCEPTED).build())
                        .onErrorResume(e -> ServerResponse.status(HttpStatus.NOT_FOUND).build()));
    }
}
