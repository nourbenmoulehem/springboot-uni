package tn.esprit.tp_4ever.Services.Universite;

import tn.esprit.tp_4ever.Entities.Universite;

import java.util.List;

public interface IUniversiteService {

    List<Universite> retrieveAllUniversities();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (long idUniversite);

}
