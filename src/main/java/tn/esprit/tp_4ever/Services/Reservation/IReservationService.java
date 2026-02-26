package tn.esprit.tp_4ever.Services.Reservation;

import tn.esprit.tp_4ever.Entities.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservation();
    Reservation updateReservation (Reservation res);
    Reservation retrieveReservation (long idReservation);
}
