package tn.esprit.tp_4ever.Services.Etudiant;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_4ever.Entities.Etudiant;
import tn.esprit.tp_4ever.Repositories.EtudiantRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {
    private EtudiantRepo etudiantRepo;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepo.findAll();
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return etudiantRepo.saveAll(etudiants);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepo.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return etudiantRepo.getEtudiantsByIdEtudiant(idEtudiant);
    }

    @Override
    public void removeEtudiant(long idEtudiant) {
        etudiantRepo.deleteById(idEtudiant);

    }
}
