package tn.esprit.tp_4ever.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_4ever.Entities.Etudiant;
import java.time.LocalDate;


@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant, Long> {
    Etudiant getEtudiantsByIdEtudiant(Long idEtudiant);

    long countByDateNaissanceAfterAndEcole(LocalDate date, String ecole);

    Etudiant findEtudiantByCin(Long cin);

    Long cin(Long cin);
}
