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
    int idUniversite;

    String nomUniversite;

    String adresse;

    @OneToOne
    Foyer foyer;


}
