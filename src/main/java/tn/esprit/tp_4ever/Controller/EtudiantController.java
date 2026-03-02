package tn.esprit.tp_4ever.Controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_4ever.Entities.Etudiant;
import tn.esprit.tp_4ever.Services.Etudiant.IEtudiantService;

import java.util.List;
import java.time.LocalDate;


@RestController
@AllArgsConstructor
@RequestMapping("/api/etudiant")
@Tag(name = "Etudiant api doc")
public class EtudiantController {

    private IEtudiantService etudiantService;

    @GetMapping("/getAll")
    public List<Etudiant> getAllEtudiant() {
        return etudiantService.retrieveAllEtudiants();
    }

    @PostMapping
    public List<Etudiant> addEtudiants(@RequestBody List<Etudiant> newEtudiants) {
        return etudiantService.addEtudiants(newEtudiants);
    }

    @PatchMapping
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        return etudiantService.updateEtudiant(e);
    }

    @GetMapping("getById")
    public Etudiant getEtudiantById(@RequestParam("id") long id) {
        return etudiantService.retrieveEtudiant(id);
    }

    @DeleteMapping
    public String deleteEtudiant(@RequestParam("id") long id) {
        etudiantService.removeEtudiant(id);
        return "Etudiant with id " + id + " got deleted!";
    }

    @GetMapping("/countByDateAndEcole")
    @Operation(description = "counting number of etudiants by date and by ecole")
    public long countByDateAndEcole(@RequestParam String date, @RequestParam String ecole) {
        return etudiantService.countByDateNaissanceAfterAndEcole(LocalDate.parse(date), ecole);
    }

}
