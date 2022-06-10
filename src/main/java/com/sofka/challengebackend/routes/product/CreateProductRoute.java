package com.sofka.challengebackend.routes.product;

import com.sofka.challengebackend.DTO.ProductDTO;
import com.sofka.challengebackend.usecases.product.CreateProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateProductRoute {

    @Bean
    public RouterFunction<ServerResponse> newProduct(CreateProductUseCase createProductUseCase){
        return route(POST("/create/product").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProductDTO.class)
                        .flatMap(productDTO -> createProductUseCase.createProduct(productDTO))
                        .flatMap(productDTO -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(productDTO))
                        .onErrorResume(throwable -> ServerResponse.badRequest().build()));
    }
}
