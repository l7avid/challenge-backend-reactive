package com.sofka.challengebackend.mapper;

import com.sofka.challengebackend.DTO.BillDTO;
import com.sofka.challengebackend.collections.Bill;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class BillMapper {

    private final ModelMapper mapper;

    public BillMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public BillDTO toBillDTO(Bill bill){
        return mapper.map(bill, BillDTO.class);
    }

    public Bill toBill(BillDTO billDTO){
        return mapper.map(billDTO, Bill.class);
    }
}
