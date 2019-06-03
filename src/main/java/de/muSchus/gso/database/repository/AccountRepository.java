package de.muSchus.gso.database.repository;

import de.muSchus.gso.database.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT u FROM Account u WHERE LOWER(u.nutzername) LIKE lower(?1) AND lower(u.passwort) LIKE lower(?2)")
    Account findFirstByNutzernameAndPasswort(String nutzername, String passwort);

    Account findFirstByNutzername(String nutzername);
}
