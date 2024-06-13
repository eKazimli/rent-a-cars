package org.example.rentacar.database.contact.repository;

import org.example.rentacar.database.contact.entity.users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByAdminName(String adminName);
}
