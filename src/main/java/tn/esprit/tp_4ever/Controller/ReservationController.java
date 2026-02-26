package tn.esprit.tp_4ever.Controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_4ever.Entities.Reservation;
import tn.esprit.tp_4ever.Services.Reservation.IReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reservation")
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


}
