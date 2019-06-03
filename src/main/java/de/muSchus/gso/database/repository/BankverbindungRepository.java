package de.muSchus.gso.database.repository;

import de.muSchus.gso.database.entity.Bankverbindung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankverbindungRepository extends JpaRepository<Bankverbindung, Long> {
}
