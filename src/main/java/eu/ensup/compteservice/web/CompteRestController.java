package eu.ensup.compteservice.web;

import eu.ensup.compteservice.domaine.Compte;
import eu.ensup.compteservice.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
public class CompteRestController {

    //Pour acceder à la base de donneé//
    //pour l'injection des dependances @Autowired est deprecié
    CompteRepository compteRepository;

    //Injection via constructeur (spring)
    public CompteRestController(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    //List des comptes
   @GetMapping(path = "/comptes")
   public List<Compte> listComptes(){
        return compteRepository.findAll();
   }

    //Consulter un compte
    @GetMapping(path = "/comptes/{id}")
    //@PathVariable pour indiquer que le parametre id de la methode getCompte represente le {id}
    public Compte getCompte(@PathVariable Long id){
        return compteRepository.findById(id).get();
    }

    //pour creer un compte
    @PostMapping(path = "/comptes")
    // des donnes qui vien dans le comps de la requetes sous formats json
    //@RequestBody pour indiquer à spring quand il reçois une requetes http avec post ou trouver les information sur le compte (dans le coprs de la requte
    public Compte save(@RequestBody Compte compte){
        return compteRepository.save(compte);
    }

    //pour mettre à jour un compte
    @PutMapping(path = "/comptes/{code}")
    //
    //
    public Compte updateCompte(@PathVariable Long code  ,@RequestBody Compte compte){
        compte.setCode(code);
        return compteRepository.save(compte);
    }

    //pour supprimer  un compte
    @DeleteMapping(path = "/comptes/{code}")
    public void deleteCompte(@PathVariable Long code){
       compteRepository.deleteById(code);
    }
}
