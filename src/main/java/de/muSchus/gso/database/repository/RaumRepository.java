package de.muSchus.gso.database.repository;

import de.muSchus.gso.database.entity.Raum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaumRepository extends JpaRepository<Raum, Long> {
}
