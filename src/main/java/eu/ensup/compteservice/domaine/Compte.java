package eu.ensup.compteservice.domaine;

import eu.ensup.compteservice.enums.TypeCompte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
// @Data "lombok" pour ajouter les getteurs et setteurs
// @NoArgsConstructor @AllArgsConstructor pour ajouter des constructeur avec et sans parametre
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Compte {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private double solde;
    private Date dateCreation;
    @Enumerated (EnumType.STRING)
    private TypeCompte typeCompte;

}
