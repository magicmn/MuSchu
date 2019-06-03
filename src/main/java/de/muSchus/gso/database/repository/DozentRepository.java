package de.muSchus.gso.database.repository;

import de.muSchus.gso.database.entity.Dozent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DozentRepository extends JpaRepository<Dozent, Long> {
}
