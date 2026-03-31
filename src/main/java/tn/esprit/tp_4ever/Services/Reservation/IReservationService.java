package tn.esprit.tp_4ever.Services.Reservation;

import tn.esprit.tp_4ever.Entities.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface IReservationService {

    List<Reservation> retrieveAllReservation();

    Reservation updateReservation(Reservation res);

    Reservation retrieveReservation(long idReservation);

    List<Reservation> getValidReservationsByYear(int annee);

    Reservation ajouterReservation(long idBloc, long cinEtudiant);

    Reservation annulerReservation(long cinEtudiant);

    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(LocalDate anneeUniversite, String nomUniversite);

}
