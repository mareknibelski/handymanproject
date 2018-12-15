package pl.coderslab.handyman.repository;

import pl.coderslab.handyman.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
    Role findById(Long id);
}
