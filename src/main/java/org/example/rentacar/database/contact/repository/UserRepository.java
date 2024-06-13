package org.example.rentacar.database.contact.repository;

import org.example.rentacar.database.contact.entity.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByFin(String fin);
    Optional<User> findByUsername(String username);
}
