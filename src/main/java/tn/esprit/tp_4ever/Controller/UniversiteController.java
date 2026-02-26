package tn.esprit.tp_4ever.Controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_4ever.Entities.Universite;
import tn.esprit.tp_4ever.Services.Universite.IUniversiteService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/universite")
public class UniversiteController {

    private IUniversiteService universiteService;


    @GetMapping("/getAll")
    public List<Universite> getAllUniversite() {
        return universiteService.retrieveAllUniversities();
    }

    @PostMapping
    public Universite addUniversite(@RequestBody Universite newUniversite) {
        return universiteService.addUniversite(newUniversite);
    }

    @PatchMapping
    public Universite updateUniversite(@RequestBody Universite e) {
        return universiteService.updateUniversite(e);
    }

    @GetMapping("getById")
    public Universite getUniversiteById(@RequestParam("id") long id) {
        return universiteService.retrieveUniversite(id);
    }


}
