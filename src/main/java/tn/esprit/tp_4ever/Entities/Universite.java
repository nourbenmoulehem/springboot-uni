package tn.esprit.tp_4ever.Entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Universite {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idUniversite;

    String nomUniversite;

    String adresse;

    @OneToOne(cascade = CascadeType.PERSIST)
    Foyer foyer;


}
