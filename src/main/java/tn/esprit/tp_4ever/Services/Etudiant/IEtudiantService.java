package tn.esprit.tp_4ever.Services.Etudiant;

import tn.esprit.tp_4ever.Entities.Etudiant;

import java.util.List;


public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();
    List<Etudiant> addEtudiants (List<Etudiant> etudiants);
    Etudiant updateEtudiant (Etudiant e);
    Etudiant retrieveEtudiant(long idEtudiant);
    void removeEtudiant(long idEtudiant);

}
