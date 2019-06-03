package de.muSchus.gso.database.repository;

import de.muSchus.gso.database.entity.Kurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KursRepository extends JpaRepository<Kurs, Long> {
}
