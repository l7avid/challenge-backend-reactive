package com.sofka.challengebackend.mapper;

import com.sofka.challengebackend.DTO.ProductDTO;
import com.sofka.challengebackend.collections.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class ProductMapper {

    private final ModelMapper mapper;

    public ProductMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public ProductDTO toProductDTO(Product purveyor){
        return mapper.map(purveyor, ProductDTO.class);
    }

    public Product toProduct(ProductDTO purveyorDTO){
        return mapper.map(purveyorDTO, Product.class);
    }
}
