package com.sofka.challengebackend.DTO;

import com.sofka.challengebackend.collections.Product;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class BillDTO {

    private String id;
    @NotBlank(message = "Date cannot be blank")
    private LocalDateTime date;
    @NotBlank(message = "Client cannot be blank")
    private String client;
    @NotBlank(message = "Seller cannot be blank")
    private String seller;
    @NotBlank(message = "Paid cannot be blank")
    private String totalPaid;
    @NotBlank(message = "Product cannot be blank")
    private List<Product> products;
}
