package org.example.rentacar.database.contact.repository;

import org.example.rentacar.database.contact.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
