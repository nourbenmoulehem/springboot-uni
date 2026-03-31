package tn.esprit.tp_4ever.Controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_4ever.Entities.Reservation;
import tn.esprit.tp_4ever.Services.Reservation.IReservationService;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reservation")
@Tag(name = "Gestion Reservation api documentation")
public class ReservationController {

    private IReservationService reservationService;

    @GetMapping("/getAll")
    public List<Reservation> getAllReservation() {
        return reservationService.retrieveAllReservation();
    }

//    @PostMapping
//    public List<Reservation> addReservations(List<Reservation> newReservations) {
//        return reservationService.addReservations(newReservations);
//    }

    @PatchMapping
    public Reservation updateReservation(@RequestBody Reservation e) {
        return reservationService.updateReservation(e);
    }

    @GetMapping("/getById")
    public Reservation getReservationById(@RequestParam long id) {
        return reservationService.retrieveReservation(id);
    }

    @GetMapping("/getValidByYear")
    @Operation(description = "get valid reservation by year")
    public List<Reservation> getValidReservationsByYear(@RequestParam int annee) {
        return reservationService.getValidReservationsByYear(annee);
    }

    @PostMapping("/ajouterReservation/{idBloc}/{cinEtudiant}")
    public Reservation ajouterReservation(@PathVariable long idBloc,
                                          @PathVariable long cinEtudiant) {
        return reservationService.ajouterReservation(idBloc, cinEtudiant);
    }

    @GetMapping("/getByAnneeAndUniversite/{nomUniversite}")
    @Operation(description = "get reservations by academic year and university name")
    public List<Reservation> getReservationsParAnneeEtUniversite(

            @RequestParam String anneeUniversite,
            @PathVariable String nomUniversite

    ) {
        LocalDate date = LocalDate.parse(anneeUniversite);
        return reservationService.getReservationParAnneeUniversitaireEtNomUniversite(date, nomUniversite);
    }

}
