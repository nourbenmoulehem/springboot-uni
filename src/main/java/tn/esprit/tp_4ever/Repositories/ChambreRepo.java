package tn.esprit.tp_4ever.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_4ever.Entities.Chambre;
import tn.esprit.tp_4ever.Entities.TypeChambre;

import java.util.List;


@Repository
public interface ChambreRepo extends JpaRepository<Chambre, Long> {

    Chambre getChambresByIdChambre(long idChambre);

    List<Chambre> findByNumeroChambre(long numeroChambre);

    List<Chambre> findByNumeroChambreAndTypec(long numeroChambre, TypeChambre typec);

    long countByBlocIdBloc(int idBloc);

    void findByIdChambre(Long idChambre);

    List<Chambre> findByBlocFoyerUniversiteNomUniversite(String nomUniversite);

    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.typec = :typeC")
    List<Chambre> findChambresParBlocEtTypeJPQL(@Param("idBloc") long idBloc, @Param("typeC") TypeChambre typeC);

    List<Chambre> findByBlocIdBlocAndTypec(long idBloc, TypeChambre typec);

    @Query("SELECT c FROM Chambre c WHERE c.typec = :type AND c.bloc.foyer.universite.nomUniversite = :nomUniversite AND c NOT IN (SELECT ch FROM Chambre ch JOIN ch.reservations r WHERE YEAR(r.anneeUniversitaire) = :currentYear)")
    List<Chambre> findChambresNonReservees(@Param("nomUniversite") String nomUniversite, @Param("type") TypeChambre type, @Param("currentYear") int currentYear);

}
