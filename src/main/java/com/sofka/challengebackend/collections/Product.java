package com.sofka.challengebackend.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection = "product")
@Data
public class Product {

    @Id
    private String productId;
    @NotBlank(message = "Product name cannot be blank")
    private String productName;
    @NotBlank(message = "Product description cannot be blank")
    private String productDescription;
    @NotBlank(message = "Product minimum amount cannot be blank")
    private Integer minAmount;
    @NotBlank(message = "Product maximum amount cannot be blank")
    private Integer maxAmount;
    @NotBlank(message = "Product available units cannot be blank")
    private Integer availableUnits = 0;
    @NotBlank(message = "Product price cannot be blank")
    private Integer productPrice;
    @NotBlank(message = "Purveyor id cannot be blank")
    private String purveyorId;
}
