package com.sofka.challengebackend.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Document(collection = "receipt")
@Data
public class Receipt {

    @Id
    private String receiptId;
    @NotBlank(message = "purveyor cannot be blank")
    private Purveyor purveyor;
    private LocalDateTime date;
    @NotBlank(message = "products cannot be blank")
    private Product product;

}
