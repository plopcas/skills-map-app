package plopcas.skillsmap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import plopcas.skillsmap.model.TechnologyExperience;
import plopcas.skillsmap.model.TechnologyExperienceId;

@Repository("TechnologyExperience")
public interface TechnologyExperienceRepository extends JpaRepository<TechnologyExperience, TechnologyExperienceId> {

    public List<TechnologyExperience> findByPersonId(Long personId);

    public List<TechnologyExperience> findByTechnologyId(Long technologyId);

    public List<TechnologyExperience> findByYear(Integer year);

}
