package tn.esprit.tp_4ever.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_4ever.Entities.Chambre;


@Repository
public interface ChambreRepo extends JpaRepository<Chambre, Long> {
}
