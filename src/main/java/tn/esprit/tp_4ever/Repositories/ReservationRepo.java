package tn.esprit.tp_4ever.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_4ever.Entities.Reservation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;



@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r WHERE r.estValide = true AND YEAR(r.anneeUniversitaire) = :annee")
    List<Reservation> findValidReservationsByYear(@Param("annee") int annee);
}
