package tn.esprit.tp_4ever.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_4ever.Entities.Bloc;


@Repository
public interface BlocRepo extends JpaRepository<Bloc, Long> {
    Bloc getBlocsByIdBloc(long idBloc);
}
