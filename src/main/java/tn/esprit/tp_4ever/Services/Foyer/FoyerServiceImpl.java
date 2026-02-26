package tn.esprit.tp_4ever.Services.Foyer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_4ever.Entities.Foyer;
import tn.esprit.tp_4ever.Repositories.FoyerRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService {
    private FoyerRepo foyerRepo;

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepo.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepo.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepo.save(f);
    }

    @Override
    public Foyer retrieveFoyer(int idFoyer) {
        return foyerRepo.getFoyerByIdFoyer(idFoyer);
    }

    @Override
    public void removeFoyer(int idFoyer) {
        foyerRepo.deleteById(idFoyer);

    }
}
