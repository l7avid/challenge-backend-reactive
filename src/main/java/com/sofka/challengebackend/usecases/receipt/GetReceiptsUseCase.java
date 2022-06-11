package com.sofka.challengebackend.usecases.receipt;

import com.sofka.challengebackend.DTO.ReceiptDTO;
import com.sofka.challengebackend.mapper.ReceiptMapper;
import com.sofka.challengebackend.repository.IReceiptRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetReceiptsUseCase {

    private final IReceiptRepository repository;
    private final ReceiptMapper mapper;


    public GetReceiptsUseCase(IReceiptRepository repository, ReceiptMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    Flux<ReceiptDTO> getAllReceipts(){
        return repository.findAll().map(receipt -> mapper.toReceiptDTO(receipt));
    }
}
