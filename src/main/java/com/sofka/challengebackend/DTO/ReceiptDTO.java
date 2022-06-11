package com.sofka.challengebackend.DTO;

import com.sofka.challengebackend.collections.Product;
import com.sofka.challengebackend.collections.Purveyor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class ReceiptDTO {

    private String receiptId;
    @NotBlank(message = "purveyor id cannot be blank")
    private String purveyorId;
    private LocalDateTime date;
    @NotBlank(message = "product id cannot be blank")
    private String productId;
}
