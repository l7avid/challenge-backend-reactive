package com.sofka.challengebackend.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "bill")
public class Bill {

    @Id
    private String id;
    @NotBlank(message = "Date cannot be blank")
    private String date;
    @NotBlank(message = "Client cannot be blank")
    private String client;
    @NotBlank(message = "Seller cannot be blank")
    private String seller;
    @NotBlank(message = "Paid cannot be blank")
    private Integer totalPaid;
    @NotBlank(message = "Product cannot be blank")
    private List<String> productsId;
}

