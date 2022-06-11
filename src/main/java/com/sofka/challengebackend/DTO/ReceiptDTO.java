package com.sofka.challengebackend.DTO;

import com.sofka.challengebackend.collections.Product;
import com.sofka.challengebackend.collections.Purveyor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class ReceiptDTO {

    private String receiptId;
    @NotBlank(message = "purveyor cannot be blank")
    private Purveyor purveyor;
    @NotBlank(message = "date cannot be blank")
    private LocalDateTime date;
    @NotBlank(message = "product cannot be blank")
    private Product product;
}
