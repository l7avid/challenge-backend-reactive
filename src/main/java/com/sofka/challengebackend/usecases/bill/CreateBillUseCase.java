package com.sofka.challengebackend.usecases.bill;

import com.sofka.challengebackend.DTO.BillDTO;
import com.sofka.challengebackend.mapper.BillMapper;
import com.sofka.challengebackend.repository.IBillRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateBillUseCase {

    private final IBillRepository repository;
    private final BillMapper mapper;

    public CreateBillUseCase(IBillRepository repository, BillMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    private boolean validateAttributes(BillDTO billDTO){
        return billDTO.getDate() != null &&
                billDTO.getClient() != null &&
                billDTO.getSeller() != null &&
                billDTO.getTotalPaid() != null &&
                billDTO.getProducts() != null;
    }

    private Mono<BillDTO> validateBill(BillDTO billDTO){
        return Mono.just(billDTO)
                .filter(billDTO1 -> validateAttributes(billDTO1))
                .switchIfEmpty(Mono.error(()-> new Exception("Missing attributes")));
    }

    public Mono<BillDTO> createBill(BillDTO billDTO){
        return validateBill(billDTO)
                .flatMap(billDTO1 -> repository.save(mapper.toBill(billDTO1)))
                .map(bill -> mapper.toBillDTO(bill));
    }
}
