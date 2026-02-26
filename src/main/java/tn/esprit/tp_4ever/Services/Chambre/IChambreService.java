package tn.esprit.tp_4ever.Services.Chambre;

import tn.esprit.tp_4ever.Entities.Chambre;
import tn.esprit.tp_4ever.Entities.TypeChambre;

import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllChambres();
    Chambre addChambre(Chambre c);
    Chambre updateChambre (Chambre c);
    Chambre retrieveChambre (long idChambre);
    void deleteChambre(long idChambre);
    List<Chambre> getByNumeroChambreAndtype(long numeroChambre, TypeChambre typeChambre);
}
