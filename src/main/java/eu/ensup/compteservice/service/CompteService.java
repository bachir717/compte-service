package eu.ensup.compteservice.service;

public interface CompteService {

    public void virement(Long codeSource, Long codeEstimation, double montant);
}
