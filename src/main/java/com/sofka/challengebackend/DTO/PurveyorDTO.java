package com.sofka.challengebackend.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PurveyorDTO {

    private String purveyorId;
    @NotBlank(message = "Purveyor Name cannot be blank")
    private String purveyorName;
    @NotBlank(message = "Purveyor Id cannot be blank")
    private String purveyorIdentification;
    @NotBlank(message = "Email cannot be blank")
    private String purveyorEmail;

}
