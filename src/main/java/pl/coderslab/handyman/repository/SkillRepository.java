package pl.coderslab.handyman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.handyman.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {

//    Skill findById(Long id);

}
