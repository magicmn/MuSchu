package de.muSchus.gso.database.repository;

import de.muSchus.gso.database.entity.Dozent;
import de.muSchus.gso.database.entity.Stunde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StundeRepository extends JpaRepository<Stunde, Long> {

    @Query("SELECT u FROM Stunde u WHERE u.kurs.dozent = ?1 AND u.start >= ?2 AND u.start <= ?3 ORDER BY u.start")
    List<Stunde> findAllByDozentAndDatumBetween(Dozent dozent, LocalDateTime start, LocalDateTime end);

    @Query("SELECT u FROM Stunde u WHERE u.kurs.dozent = ?1 ORDER BY u.start DESC ")
    List<Stunde> findAllByDozent(Dozent dozent);
}
