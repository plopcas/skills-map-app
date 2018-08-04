package plopcas.skillsmap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import plopcas.skillsmap.model.ProductExperience;
import plopcas.skillsmap.model.ProductExperienceId;

@Repository("ProductExperienceRepository")
public interface ProductExperienceRepository extends JpaRepository<ProductExperience, ProductExperienceId> {

    public List<ProductExperience> findByPersonId(Long personId);

    public List<ProductExperience> findByProductId(Long productId);

    public List<ProductExperience> findByYear(Integer year);
    
}
