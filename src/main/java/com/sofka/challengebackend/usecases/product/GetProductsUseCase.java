package com.sofka.challengebackend.usecases.product;

import com.sofka.challengebackend.DTO.ProductDTO;
import com.sofka.challengebackend.mapper.ProductMapper;
import com.sofka.challengebackend.repository.IProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetProductsUseCase {

    private final IProductRepository repository;
    private final ProductMapper mapper;

    public GetProductsUseCase(IProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Flux<ProductDTO> getAllProducts(){
        return repository.findAll().map(product -> mapper.toProductDTO(product));
    }
}
