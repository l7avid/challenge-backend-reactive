package com.sofka.challengebackend.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection = "purveyor")
@Data
public class Purveyor {

    @Id
    private String purveyorId;
    @NotBlank(message = "Purveyor name cannot be blank")
    private String purveyorName;
    @NotBlank(message = "Purveyor identification cannot be blank")
    private String purveyorIdentification;
    @NotBlank(message = "Email cannot be blank")
    private String purveyorEmail;


}
