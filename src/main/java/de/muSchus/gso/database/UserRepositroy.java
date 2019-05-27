package de.muSchus.gso.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositroy extends JpaRepository<User, Long> {

    User findFirstByUsernameAndPassword(String username, String password);
}
