package tn.esprit.tp_4ever.Controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_4ever.Entities.Etudiant;
import tn.esprit.tp_4ever.Services.Etudiant.IEtudiantService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/etudiant")
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
}
