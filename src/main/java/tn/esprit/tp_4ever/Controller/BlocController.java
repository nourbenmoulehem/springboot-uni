package tn.esprit.tp_4ever.Controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_4ever.Entities.Bloc;
import tn.esprit.tp_4ever.Services.Bloc.IBlocService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/bloc")
public class BlocController {

    private IBlocService blocService;

    @GetMapping("/getAll")
    public List<Bloc> getAllBlocs() {
        return blocService.retrieveBlocs();
    }

    @PatchMapping("/update")
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return blocService.updateBloc(bloc);
    }

    @PostMapping("/add")
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocService.addBloc(bloc);
    }

    @GetMapping("/getById")
    public Bloc getBlocById(@RequestParam long id) {
        return blocService.retrieveBloc(id);
    }

    @DeleteMapping("/delete")
    public String deleteBloc(@RequestParam long id) {
        blocService.removeBloc(id);
        return "Bloc deleted!";
    }

}
