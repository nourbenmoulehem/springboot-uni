package tn.esprit.tp_4ever.Controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_4ever.Entities.Foyer;
import tn.esprit.tp_4ever.Services.Foyer.IFoyerService;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/foyer")
@Tag(name = "Gestion Foyer APIs")
public class FoyerController {

    private IFoyerService foyerService;

    @Operation(description = "get all foyer")
    @GetMapping("/getAll")
    public List<Foyer> getAllFoyer() {
        return foyerService.retrieveAllFoyers();
    }

    @Operation(description = "insert new foyer")
    @PostMapping("/add")
    public Foyer addFoyers(@RequestBody Foyer newFoyer) {
        System.out.println("mapping to null?? are you here??????");
        return foyerService.addFoyer(newFoyer);
    }

    @Operation(description = "update a know foyer")
    @PatchMapping
    public Foyer updateFoyer(@RequestBody Foyer f) {
        return foyerService.updateFoyer(f);
    }

    @Operation(description = "get foyer by id")
    @GetMapping("/getById")
    public Foyer getFoyerById(@RequestParam int id) {
        return foyerService.retrieveFoyer(id);
    }

    @Operation(description = "delete foyer by its know id, check db")
    @DeleteMapping
    public String deleteFoyer(@RequestParam  int id) {
        foyerService.removeFoyer(id);
        return "Foyer with id " + id + " got deleted!";
    }

}
