package tn.esprit.tp_4ever.Repositories;

import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_4ever.Entities.Reservation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.time.LocalDate;



@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r WHERE r.estValide = true AND YEAR(r.anneeUniversitaire) = :annee")
    List<Reservation> findValidReservationsByYear(@Param("annee") int annee);

    List<Reservation> findByAnneeUniversitaireAndEstValide(LocalDate annee, boolean valide);

    @Query("SELECT DISTINCT r FROM Chambre c JOIN c.reservations r WHERE c.bloc.foyer.universite.nomUniversite = :nomUniversite AND YEAR(r.anneeUniversitaire) = YEAR(:anneeUniversite)")
    List<Reservation> findReservationsParAnneeEtUniversite(@Param("anneeUniversite") LocalDate anneeUniversite, @Param("nomUniversite") String nomUniversite);

}
