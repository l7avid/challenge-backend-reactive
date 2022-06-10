package com.sofka.challengebackend.usecases.product;

import com.sofka.challengebackend.repository.IProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteProductUseCase {

    private final IProductRepository repository;

    public DeleteProductUseCase(IProductRepository repository) {
        this.repository = repository;
    }

    public Mono<Void> deleteProduct(String id){
        return repository.findById(id)
                .switchIfEmpty(Mono.error(() -> new Exception("Not able to find a product with the given id")))
                .flatMap(product -> repository.deleteById(product.getProductId()));
    }
}
