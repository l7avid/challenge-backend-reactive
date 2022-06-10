package com.sofka.challengebackend.usecases.product;

import com.sofka.challengebackend.DTO.ProductDTO;
import com.sofka.challengebackend.mapper.ProductMapper;
import com.sofka.challengebackend.repository.IProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GetProductUseCase {

    private final IProductRepository repository;
    private final ProductMapper mapper;


    public GetProductUseCase(IProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Mono<ProductDTO> getProduct(String productId){
        return repository.findById(productId).map(product -> mapper.toProductDTO(product))
                .switchIfEmpty(Mono.error(() -> new Exception("Not able to find a product with the given id")));
    }
}
