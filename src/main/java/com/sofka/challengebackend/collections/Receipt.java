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
    @NotBlank(message = "purveyorId cannot be blank")
    private String purveyorId;
    private LocalDateTime date;
    @NotBlank(message = "products cannot be blank")
    private String productId;

}
