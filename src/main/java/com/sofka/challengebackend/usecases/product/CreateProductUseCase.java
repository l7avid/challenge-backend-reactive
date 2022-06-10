package com.sofka.challengebackend.usecases.product;

import com.sofka.challengebackend.DTO.ProductDTO;
import com.sofka.challengebackend.DTO.PurveyorDTO;
import com.sofka.challengebackend.mapper.ProductMapper;
import com.sofka.challengebackend.repository.IProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service

public class CreateProductUseCase {

    private final IProductRepository repository;
    private final ProductMapper mapper;

    public CreateProductUseCase(IProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public boolean validateAttributes(ProductDTO productDTO){
            return productDTO.getProductName() != null &&
                    productDTO.getProductPrice() != null &&
                    productDTO.getPurveyorName() != null &&
                    productDTO.getAvailableUnits() != null &&
                    productDTO.getMaxAmount() != null &&
                    productDTO.getMinAmount() != null;
    }

    private Mono<ProductDTO> validateProduct(ProductDTO productDTO){
        return Mono.just(productDTO)
                .filter(productDTO1 -> validateAttributes(productDTO1))
                .switchIfEmpty(Mono.error(() -> new Exception("Missing attributes")));
    }

    public Mono<ProductDTO> createProduct(ProductDTO productDTO){
        return validateProduct(productDTO)
                .flatMap(productDTO1 -> repository.save(mapper.toProduct(productDTO1)))
                .map(product -> mapper.toProductDTO(product));
    }
}
