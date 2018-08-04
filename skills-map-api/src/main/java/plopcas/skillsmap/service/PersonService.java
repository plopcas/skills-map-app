package plopcas.skillsmap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import plopcas.skillsmap.model.Person;
import plopcas.skillsmap.repository.PersonRepository;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person findOne(Long id) {
	return personRepository.findOne(id);
    }

    public List<Person> findAll() {
	return personRepository.findAll();
    }

    public Person save(Person Person) {
	return personRepository.save(Person);
    }

    public void delete(Long id) {
	personRepository.delete(id);
    }
}
