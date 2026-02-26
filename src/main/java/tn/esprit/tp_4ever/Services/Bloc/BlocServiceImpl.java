package tn.esprit.tp_4ever.Services.Bloc;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_4ever.Entities.Bloc;
import tn.esprit.tp_4ever.Repositories.BlocRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService{
    private BlocRepo blocRepo;

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
}
