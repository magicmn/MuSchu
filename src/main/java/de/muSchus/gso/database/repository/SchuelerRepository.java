package de.muSchus.gso.database.repository;

import de.muSchus.gso.database.entity.Schueler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchuelerRepository extends JpaRepository<Schueler, Long> {
}
