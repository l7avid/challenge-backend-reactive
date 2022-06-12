package com.sofka.challengebackend.routes.bill;

import com.sofka.challengebackend.DTO.BillDTO;
import com.sofka.challengebackend.usecases.bill.GetBillUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetBillRoute {

    @Bean
    public RouterFunction<ServerResponse> getOneBill(GetBillUseCase getBillUseCase){
        return route(GET("/get/bills"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(getBillUseCase.getAllProducts(), BillDTO.class)));
    }
}
