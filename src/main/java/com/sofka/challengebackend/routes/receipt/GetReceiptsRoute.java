package com.sofka.challengebackend.routes.receipt;

import com.sofka.challengebackend.DTO.ReceiptDTO;
import com.sofka.challengebackend.usecases.product.GetProductsUseCase;
import com.sofka.challengebackend.usecases.receipt.GetReceiptsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetReceiptsRoute {

    @Bean
    public RouterFunction<ServerResponse> getReceipts(GetReceiptsUseCase getReceiptsUseCase){
        return route(GET("/get/receipts"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(getReceiptsUseCase.getAllReceipts(), ReceiptDTO.class)));
    }
}
