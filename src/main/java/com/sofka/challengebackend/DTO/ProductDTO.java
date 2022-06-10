package com.sofka.challengebackend.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ProductDTO {

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
    @NotBlank(message = "Purveyor name cannot be blank")
    private String purveyorName;

}
