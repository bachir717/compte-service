package eu.ensup.compteservice.dto;

import lombok.Data;

@Data
public class VirementRequestDTO {
    private Long codeSource;
    private Long codedestination;
    private double montant;
}
