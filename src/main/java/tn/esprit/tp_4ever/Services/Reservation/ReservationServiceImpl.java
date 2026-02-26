package tn.esprit.tp_4ever.Services.Reservation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_4ever.Entities.Reservation;
import tn.esprit.tp_4ever.Repositories.ReservationRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {

    private ReservationRepo reservationRepo;


    @Override
    public List<Reservation> retrieveAllReservation() {
        return List.of();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return null;
    }

    @Override
    public Reservation retrieveReservation(long idReservation) {
        return null;
    }
}
