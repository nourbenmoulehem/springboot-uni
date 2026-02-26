package tn.esprit.tp_4ever.Services.Chambre;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_4ever.Entities.Chambre;
import tn.esprit.tp_4ever.Entities.TypeChambre;
import tn.esprit.tp_4ever.Repositories.ChambreRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService{

    private ChambreRepo chambreRepo;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepo.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepo.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepo.save(c);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return chambreRepo.getChambresByIdChambre(idChambre);
    }

    @Override
    public void deleteChambre(long idChambre) {

        chambreRepo.deleteById(idChambre);

    }

    @Override
    public List<Chambre> getByNumeroChambreAndtype(long numeroChambre, TypeChambre typeChambre) {
        return chambreRepo.findByNumeroChambreAndTypec(numeroChambre, typeChambre);
    }


}
