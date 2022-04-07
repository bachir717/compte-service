package eu.ensup.compteservice.service;

import eu.ensup.compteservice.domaine.Compte;
import eu.ensup.compteservice.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional  //pas besoins d'utiliser save() apres ligne 20
public class CompteServiceImpl implements CompteService{
    @Autowired
    private CompteRepository compteRepository;
    @Override
    public void virement(Long codeSource, Long codeEstimation, double montant) {
      Compte c1 = compteRepository.getById(codeSource);
      Compte c2 = compteRepository.getById(codeEstimation);
        c1.setSolde(c1.getSolde()-montant);
        c2.setSolde(c2.getSolde()+montant);
        //optionel
        compteRepository.save(c1);
        compteRepository.save(c2);
    }
}
