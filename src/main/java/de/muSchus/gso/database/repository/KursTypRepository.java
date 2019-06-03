package de.muSchus.gso.database.repository;

import de.muSchus.gso.database.entity.KursTyp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KursTypRepository extends JpaRepository<KursTyp, Long> {

    List<KursTyp> findByBezeichnungIn(String[] kursTypen);
}
