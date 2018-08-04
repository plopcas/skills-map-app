package plopcas.skillsmap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import plopcas.skillsmap.model.Person;

@Repository("PersonRepository")
public interface PersonRepository extends JpaRepository<Person, Long> {

    public List<Person> findByName(String name);
}
