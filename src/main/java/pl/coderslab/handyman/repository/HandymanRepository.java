package pl.coderslab.handyman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.handyman.entity.Handyman;

public interface HandymanRepository extends JpaRepository<Handyman, Long> {

    Handyman findByEmail(String email);

}
