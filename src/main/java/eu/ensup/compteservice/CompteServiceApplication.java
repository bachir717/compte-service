package eu.ensup.compteservice;

import eu.ensup.compteservice.domaine.Compte;
import eu.ensup.compteservice.enums.TypeCompte;
import eu.ensup.compteservice.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class CompteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompteServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository, RepositoryRestConfiguration restConfiguration){
        return args -> {
            //exposer le id (avec json)
            restConfiguration.exposeIdsFor(Compte.class);
            compteRepository.save(new Compte(null,7500,new Date(), TypeCompte.COURANT));
            compteRepository.save(new Compte(null,24400,new Date(), TypeCompte.EPARGNE));
            compteRepository.save(new Compte(null,91500,new Date(), TypeCompte.EPARGNE));
            compteRepository.save(new Compte(null,3700,new Date(), TypeCompte.COURANT));
            compteRepository.findAll().forEach(cp-> {
                System.out.println(cp.getTypeCompte());
                System.out.println(cp.getSolde());
            });
        };
    }

}
