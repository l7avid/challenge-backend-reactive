package com.sofka.challengebackend.routes.receipt;

import com.sofka.challengebackend.DTO.ReceiptDTO;
import com.sofka.challengebackend.usecases.receipt.CreateReceiptUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateReceiptRoute {

    @Bean
    public RouterFunction<ServerResponse> createReceipt(CreateReceiptUseCase createReceiptUseCase){
        return route(POST("/create/receipt").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ReceiptDTO.class)
                        .flatMap(receiptDTO -> createReceiptUseCase.createReceipt(receiptDTO))
                        .flatMap(receiptDTO -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(receiptDTO))
                        .onErrorResume(throwable -> ServerResponse.notFound().build()));
    }
}
