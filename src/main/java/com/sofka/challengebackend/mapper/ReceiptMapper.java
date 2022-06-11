package com.sofka.challengebackend.mapper;

import com.sofka.challengebackend.DTO.ReceiptDTO;
import com.sofka.challengebackend.collections.Receipt;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class ReceiptMapper {

    private final ModelMapper mapper;

    public ReceiptMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public ReceiptDTO toReceiptDTO(Receipt receipt){
        return mapper.map(receipt, ReceiptDTO.class);
    }

    public Receipt toReceipt(ReceiptDTO receiptDTO){
        return mapper.map(receiptDTO, Receipt.class);
    }
}
