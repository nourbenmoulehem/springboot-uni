package tn.esprit.tp_4ever.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_4ever.Entities.Reservation;


@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long> {
}
