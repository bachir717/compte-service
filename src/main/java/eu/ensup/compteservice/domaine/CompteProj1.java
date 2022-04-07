package eu.ensup.compteservice.domaine;

import org.springframework.data.rest.core.config.Projection;

//grace à spring data rest on peut spécifir les éléments à afficher
//http://localhost:8082/comptes?projection=p1
@Projection(name = "p1", types = Compte.class)
public interface CompteProj1 {
    public Long getCode();
    public double getSolde();
}
