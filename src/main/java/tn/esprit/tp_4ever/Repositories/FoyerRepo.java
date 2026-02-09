package tn.esprit.tp_4ever.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_4ever.Entities.Foyer;


@Repository
public interface FoyerRepo extends JpaRepository<Foyer, Long> {
}
