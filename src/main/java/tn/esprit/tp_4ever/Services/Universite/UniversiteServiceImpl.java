package tn.esprit.tp_4ever.Services.Universite;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_4ever.Entities.Universite;
import tn.esprit.tp_4ever.Repositories.UniversiteRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService {

    private UniversiteRepo universiteRepo;


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
}
