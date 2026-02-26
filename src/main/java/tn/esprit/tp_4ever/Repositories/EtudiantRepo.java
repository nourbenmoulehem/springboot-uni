package tn.esprit.tp_4ever.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_4ever.Entities.Etudiant;

@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant, Long> {
    Etudiant getEtudiantsByIdEtudiant(Long idEtudiant);
}
