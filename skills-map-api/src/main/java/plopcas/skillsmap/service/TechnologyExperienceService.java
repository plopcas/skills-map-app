package plopcas.skillsmap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import plopcas.skillsmap.model.TechnologyExperience;
import plopcas.skillsmap.model.TechnologyExperienceId;
import plopcas.skillsmap.repository.TechnologyExperienceRepository;

@Service
public class TechnologyExperienceService {
    @Autowired
    private TechnologyExperienceRepository technologyExperienceRepository;

    public TechnologyExperience findOne(TechnologyExperienceId id) {
	return technologyExperienceRepository.findOne(id);
    }

    public List<TechnologyExperience> findAll() {
	return technologyExperienceRepository.findAll();
    }

    public List<TechnologyExperience> findByPersonId(Long personId) {
	return technologyExperienceRepository.findByPersonId(personId);
    }

    public List<TechnologyExperience> findByProductId(Long technologyId) {
	return technologyExperienceRepository.findByTechnologyId(technologyId);
    }

    public List<TechnologyExperience> findByYear(Integer year) {
	return technologyExperienceRepository.findByYear(year);
    }

    public TechnologyExperience save(TechnologyExperience TechnologyExperience) {
	return technologyExperienceRepository.save(TechnologyExperience);
    }

    public void delete(TechnologyExperienceId id) {
	technologyExperienceRepository.delete(id);
    }
}
