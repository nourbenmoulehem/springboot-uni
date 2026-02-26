package tn.esprit.tp_4ever.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Foyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idFoyer;

    String nomFoyer;

    Long capaciteFoyer;

    @OneToOne(mappedBy = "foyer")
    Universite universite;

    @OneToMany(mappedBy = "foyer", fetch = FetchType.LAZY)
    Set<Bloc> blocs;
}
