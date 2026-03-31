package tn.esprit.tp_4ever.Services.Universite;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_4ever.Entities.Foyer;
import tn.esprit.tp_4ever.Entities.Universite;
import tn.esprit.tp_4ever.Repositories.FoyerRepo;
import tn.esprit.tp_4ever.Repositories.UniversiteRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService {

    private UniversiteRepo universiteRepo;
    private FoyerRepo foyerRepo;


    @Override
    public List<Universite> retrieveAllUniversities() {
        return universiteRepo.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepo.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepo.save(u);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiteRepo.getUniversiteByIdUniversite(idUniversite);
    }

    @Override
    public Universite affecterFoyerAUniversite(int idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepo.getFoyerByIdFoyer(idFoyer);

        Universite uni = universiteRepo.findUniversiteByNomUniversite(nomUniversite);

        uni.setFoyer(foyer);
        universiteRepo.save(uni);
        return uni;
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite uni = universiteRepo.findUniversiteByIdUniversite(idUniversite);

        uni.setFoyer(null);

        universiteRepo.save(uni);
        return uni;
    }


}
