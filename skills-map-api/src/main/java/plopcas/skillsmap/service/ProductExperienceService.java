package plopcas.skillsmap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import plopcas.skillsmap.model.ProductExperience;
import plopcas.skillsmap.model.ProductExperienceId;
import plopcas.skillsmap.repository.ProductExperienceRepository;

@Service
public class ProductExperienceService {
    @Autowired
    private ProductExperienceRepository productExperienceRepository;

    public ProductExperience findOne(ProductExperienceId id) {
	return productExperienceRepository.findOne(id);
    }

    public List<ProductExperience> findAll() {
	return productExperienceRepository.findAll();
    }

    public List<ProductExperience> findByPersonId(Long personId) {
	return productExperienceRepository.findByPersonId(personId);
    }

    public List<ProductExperience> findByProductId(Long productId) {
	return productExperienceRepository.findByProductId(productId);
    }

    public List<ProductExperience> findByYear(Integer year) {
	return productExperienceRepository.findByYear(year);
    }

    public ProductExperience save(ProductExperience ProductExperience) {
	return productExperienceRepository.save(ProductExperience);
    }

    public void delete(ProductExperienceId id) {
	productExperienceRepository.delete(id);
    }
}
