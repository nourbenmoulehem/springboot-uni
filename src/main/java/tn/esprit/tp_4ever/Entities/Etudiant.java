package tn.esprit.tp_4ever.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Etudiant {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEtudiant;

    @Column(nullable = false)
    String nomEt;


    @Column(nullable = false)
    String prenomEt;


    @Column(unique = true)
    Long cin;

    String ecole;

    LocalDate dateNaissance;

    @ManyToMany(mappedBy = "etudiants")
    Set<Reservation> reservations;
}
