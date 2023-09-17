package com.example.onlinebookstore.repository;

import com.example.onlinebookstore.model.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> getByName(Role.RoleName name);
}
