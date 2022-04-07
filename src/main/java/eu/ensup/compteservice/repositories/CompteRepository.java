package eu.ensup.compteservice.repositories;

import eu.ensup.compteservice.domaine.Compte;
import eu.ensup.compteservice.enums.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

//@RepositoryRestResource grace à springdatarest
//spring démarre un rest controller qui acced à toutes les opérations qui existent dans cette intrface
@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {
    @RestResource(path = "/byType")
    List<Compte> findByTypeCompte(@Param(value="typeCompte") TypeCompte typeCompte);
}
