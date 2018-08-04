package plopcas.skillsmap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import plopcas.skillsmap.model.Technology;

@Repository("TechnologyRepository")
public interface TechnologyRepository extends JpaRepository<Technology, Long> {

}
