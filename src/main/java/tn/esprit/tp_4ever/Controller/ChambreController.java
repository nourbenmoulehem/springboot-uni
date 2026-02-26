package tn.esprit.tp_4ever.Controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_4ever.Entities.Chambre;
import tn.esprit.tp_4ever.Entities.TypeChambre;
import tn.esprit.tp_4ever.Services.Chambre.IChambreService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/chambre")
@Tag(name = "Gestion Chambre api documentation")
public class ChambreController {

    private IChambreService chambreService;

    @GetMapping("/getAll")
    @Operation(description = "retrieve ALL chambre in the database")
    public ResponseEntity<List<Chambre>> getAllChambres() {
        return ResponseEntity.status(HttpStatus.OK).body(chambreService.retrieveAllChambres());
    }



     @GetMapping("/getChambre/{idChambre}")
     @Operation(description = "getting one chambre  by a known id")
     public ResponseEntity<Chambre> getChambreById(@PathVariable long idChambre) {
         return ResponseEntity.status(HttpStatus.OK).body(chambreService.retrieveChambre(idChambre));
     }

    @PostMapping("/addChambre")
    @Operation(description = "adding a new chambre")
    public ResponseEntity<Chambre> addChambreById(@RequestBody Chambre chambre) {
        return ResponseEntity.status(HttpStatus.OK).body(chambreService.addChambre(chambre));
    }

    @PutMapping("/updateChambre")
    @Operation(description = "updating a  known chambre")
    public ResponseEntity<Chambre> updateChambre(@RequestBody Chambre chambre) {
        return ResponseEntity.status(HttpStatus.OK).body(chambreService.updateChambre(chambre));
    }

    @DeleteMapping("/delete")
    @Operation(description = "deleting a known chambre by it id only, the id is sent in the query param")
    public String deleteChambre(@RequestParam long idChambre) {
        chambreService.deleteChambre(idChambre);
        return "deleted a chambre";
    }

    @GetMapping("/getByNumeroAndType/{numero}/{type}")
    @Operation(description = "getting list of chambre by numero and type")
    public List<Chambre> getByNumeroAndByType(@PathVariable long numero, @PathVariable("type")TypeChambre type) {
        return chambreService.getByNumeroChambreAndtype(numero, type);
    }


}
