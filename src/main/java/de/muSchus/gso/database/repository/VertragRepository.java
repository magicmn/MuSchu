package de.muSchus.gso.database.repository;

import de.muSchus.gso.database.entity.Vertrag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VertragRepository extends JpaRepository<Vertrag, Long> {
}
