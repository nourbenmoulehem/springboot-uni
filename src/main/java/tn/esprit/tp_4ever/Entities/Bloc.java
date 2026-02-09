package tn.esprit.tp_4ever.Entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Bloc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idBloc;

    String nomBloc;

    Long capaciteBloc;

    @ManyToOne
    Foyer foyer;


    @OneToMany(mappedBy = "bloc")
    Set<Chambre> chambres;
}
