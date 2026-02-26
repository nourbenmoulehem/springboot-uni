package tn.esprit.tp_4ever.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_4ever.Entities.Chambre;
import tn.esprit.tp_4ever.Entities.TypeChambre;

import java.util.List;


@Repository
public interface ChambreRepo extends JpaRepository<Chambre, Long> {
    Chambre getChambresByIdChambre(long idChambre);

    List<Chambre> findByNumeroChambre(long numeroChambre);

    List<Chambre> findByNumeroChambreAndTypec(long numeroChambre, TypeChambre typec);
}
