package tn.esprit.tp_4ever.Services.Foyer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_4ever.Entities.Bloc;
import tn.esprit.tp_4ever.Entities.Foyer;
import tn.esprit.tp_4ever.Entities.Universite;
import tn.esprit.tp_4ever.Repositories.BlocRepo;
import tn.esprit.tp_4ever.Repositories.FoyerRepo;
import tn.esprit.tp_4ever.Repositories.UniversiteRepo;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService {
    private FoyerRepo foyerRepo;
    private UniversiteRepo universiteRepo;
    private BlocRepo blocRepo;

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

    @Override
    public Foyer getFoyerByNom(String nomFoyer) {
        return foyerRepo.findByNomFoyer(nomFoyer);
    }

    @Override
    public Foyer getFoyerByNomAndCapaciteLessThan(String nomFoyer, Long capacite) {
        return foyerRepo.findByNomFoyerAndCapaciteFoyerLessThan(nomFoyer, capacite);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {

        Universite universite = universiteRepo.findUniversiteByIdUniversite(idUniversite);

        Set<Bloc> blocNew = foyer.getBlocs();

        foyerRepo.save(foyer);

        for ( Bloc b : blocNew) {
            b.setFoyer(foyer);
        }


        blocRepo.saveAll(blocNew);





        universite.setFoyer(foyer);

        universiteRepo.save(universite);


        return foyer;
    }


}
