package tn.esprit.tp_4ever.Services.Reservation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_4ever.Entities.*;
import tn.esprit.tp_4ever.Repositories.BlocRepo;
import tn.esprit.tp_4ever.Repositories.ChambreRepo;
import tn.esprit.tp_4ever.Repositories.EtudiantRepo;
import tn.esprit.tp_4ever.Repositories.ReservationRepo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {

    private ReservationRepo reservationRepo;
    private BlocRepo blocRepo;
    private EtudiantRepo etudiantRepo;
    private ChambreRepo chambreRepo;


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

    @Override
    public List<Reservation> getValidReservationsByYear(int annee) {
        return reservationRepo.findValidReservationsByYear(annee);
    }

    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {

        Bloc bloc = blocRepo.findByIdBloc(idBloc);
        Etudiant etudiant = etudiantRepo.findEtudiantByCin(cinEtudiant);

        Chambre chambreDisponible = null;

        for (Chambre chambre : bloc.getChambres()) {

            int maxCapacity = 1;
            if (chambre.getTypec() == TypeChambre.DOUBLE) maxCapacity = 2;
            if (chambre.getTypec() == TypeChambre.TRIPLE) maxCapacity = 3;

            if (chambre.getReservations().size() < maxCapacity) {
                chambreDisponible = chambre;
                break;
            }
        }

        if (chambreDisponible == null) return null;

        int year = Calendar.getInstance().get(Calendar.YEAR);

        Reservation reservation = new Reservation();
        reservation.setNumReservation(chambreDisponible.getNumeroChambre() + "-" + bloc.getNomBloc() + "-" + year);
        reservation.setAnneeUniversitaire(LocalDate.now());
        reservation.setEstValide(true);

        reservationRepo.save(reservation);

        chambreDisponible.getReservations().add(reservation);
        chambreRepo.save(chambreDisponible);

        etudiant.getReservations().add(reservation);
        etudiantRepo.save(etudiant);

        return reservation;
    }

    @Override
    public Reservation annulerReservation(long cinEtudiant) {

        Etudiant etudiant = etudiantRepo.findEtudiantByCin(cinEtudiant);
        etudiant.setReservations(null);

        Set<Reservation> reservations = etudiant.getReservations();

        for (Reservation r : reservations) {
            r.setEstValide(false);
        }
        return null;
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(LocalDate anneeUniversite, String nomUniversite) {
        return reservationRepo.findReservationsParAnneeEtUniversite(anneeUniversite, nomUniversite);
    }

}
