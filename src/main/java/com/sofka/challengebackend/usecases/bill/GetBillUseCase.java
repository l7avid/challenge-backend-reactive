package com.sofka.challengebackend.usecases.bill;

import com.sofka.challengebackend.DTO.BillDTO;
import com.sofka.challengebackend.mapper.BillMapper;
import com.sofka.challengebackend.repository.IBillRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetBillUseCase {

    private final IBillRepository repository;
    private final BillMapper mapper;


    public GetBillUseCase(IBillRepository repository, BillMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Flux<BillDTO> getAllProducts(){
        return repository.findAll().map(bill -> mapper.toBillDTO(bill)); 
    }
}
