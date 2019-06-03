package de.muSchus.gso.database.repository;

import de.muSchus.gso.database.entity.Kondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KonditionRepository extends JpaRepository<Kondition, Long> {
}
