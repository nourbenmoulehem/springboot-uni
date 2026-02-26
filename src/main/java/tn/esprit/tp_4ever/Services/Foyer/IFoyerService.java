package tn.esprit.tp_4ever.Services.Foyer;

import tn.esprit.tp_4ever.Entities.Foyer;

import java.util.List;

public interface IFoyerService {

    List<Foyer> retrieveAllFoyers();
    Foyer addFoyer (Foyer f);
    Foyer updateFoyer (Foyer f);
    Foyer retrieveFoyer (int idFoyer);
    void removeFoyer (int idFoyer);

}
