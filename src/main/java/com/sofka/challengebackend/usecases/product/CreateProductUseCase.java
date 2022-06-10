package com.sofka.challengebackend.usecases.product;

import com.sofka.challengebackend.DTO.ProductDTO;
import com.sofka.challengebackend.mapper.ProductMapper;
import com.sofka.challengebackend.repository.IProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@Validated
public class CreateProductUseCase {

    private final IProductRepository repository;
    private final ProductMapper mapper;

    public CreateProductUseCase(IProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Mono<ProductDTO> createProduct(@Valid ProductDTO productDTO){
        return repository.save(mapper.toProduct(productDTO))
                .map(product -> mapper.toProductDTO(product));
    }
}
