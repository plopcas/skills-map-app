package plopcas.skillsmap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import plopcas.skillsmap.model.Technology;
import plopcas.skillsmap.repository.TechnologyRepository;

@Service
public class TechnologyService {
    @Autowired
    private TechnologyRepository technologyRepository;

    public Technology findOne(Long id) {
	return technologyRepository.findOne(id);
    }

    public List<Technology> findAll() {
	return technologyRepository.findAll();
    }

    public Technology save(Technology Technology) {
	return technologyRepository.save(Technology);
    }

    public void delete(Long id) {
	technologyRepository.delete(id);
    }
}
