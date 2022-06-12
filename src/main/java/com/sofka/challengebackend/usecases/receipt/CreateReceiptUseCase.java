package com.sofka.challengebackend.usecases.receipt;

import com.sofka.challengebackend.DTO.ReceiptDTO;
import com.sofka.challengebackend.mapper.ReceiptMapper;
import com.sofka.challengebackend.repository.IReceiptRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class CreateReceiptUseCase {

    private final IReceiptRepository repository;
    private final ReceiptMapper mapper;

    public CreateReceiptUseCase(IReceiptRepository repository, ReceiptMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    private boolean validateAttribute(ReceiptDTO receiptDTO){
        return receiptDTO.getPurveyorId() != null &&
                receiptDTO.getProductId() != null &&
                receiptDTO.getProductUnits() != null;
    }

    private Mono<ReceiptDTO> validateReceipt(ReceiptDTO receiptDTO){
        return  Mono.just(receiptDTO)
                .filter(receiptDTO1 -> this.validateAttribute(receiptDTO1))
                .switchIfEmpty(Mono.error(() -> new Exception("Missing Attributes")));
    }

    public Mono<ReceiptDTO> createReceipt(ReceiptDTO receiptDTO){
        receiptDTO.setDate(LocalDateTime.now(ZoneId.of("America/Bogota")).toString());
        return validateReceipt(receiptDTO)
                .flatMap(receiptDTO1 -> repository.save(mapper.toReceipt(receiptDTO1)))
                .map(receipt -> mapper.toReceiptDTO(receipt));
    }
}
