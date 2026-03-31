package tn.esprit.tp_4ever.Services.Bloc;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_4ever.Entities.Bloc;
import tn.esprit.tp_4ever.Entities.Chambre;
import tn.esprit.tp_4ever.Repositories.BlocRepo;
import tn.esprit.tp_4ever.Repositories.ChambreRepo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService{
    private BlocRepo blocRepo;
    private ChambreRepo chambreRepo;

    @Override
    public List<Bloc> retrieveBlocs() {
        return blocRepo.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepo.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepo.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepo.getBlocsByIdBloc(idBloc);
    }

    @Override
    public void removeBloc(long idBloc) {
         blocRepo.deleteById(idBloc);

    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {

        Bloc bloc = blocRepo.findByIdBloc(idBloc);


        Set<Chambre> chambresExist = bloc.getChambres();

        for ( Long idChambre : numChambre) {
            Chambre chambre = chambreRepo.getChambresByIdChambre(idChambre);
            chambre.setBloc(bloc);
            chambresExist.add(chambre);

        }

        bloc.setChambres(chambresExist);

        blocRepo.save(bloc);


        return bloc;
    }
}
