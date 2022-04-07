package eu.ensup.compteservice.web;

import eu.ensup.compteservice.dto.VirementRequestDTO;
import eu.ensup.compteservice.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccuntRestController {

    @Autowired
    private CompteService compteService;

    @PutMapping(path = "comptes/virement")
    public void virement(@RequestBody VirementRequestDTO requestDTO){
        compteService.virement(requestDTO.getCodeSource(), requestDTO.getCodedestination(), requestDTO.getMontant());
    }
}
