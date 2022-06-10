package com.sofka.challengebackend.routes.product;

import com.sofka.challengebackend.DTO.ProductDTO;
import com.sofka.challengebackend.usecases.product.GetProductsUseCase;
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
public class GetProductsRoute {

    @Bean
    public RouterFunction<ServerResponse> getAll(GetProductsUseCase getProductsUseCase){
        return route(GET("/get/products"), request -> ServerResponse.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromProducer(getProductsUseCase.getAllProducts(), ProductDTO.class)));
    }
}
