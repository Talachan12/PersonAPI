package com.example.demo.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;
@Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons(){
        return personRepository.findAll();
    }

    public void addNewPerson(Person person) {
        Optional<Person> byEmail = personRepository.findByEmail(person.getEmail());
        if (byEmail.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        personRepository.save(person);
        System.out.println(person);
        Optional<Person> byUsername = personRepository.findByUsername(person.getUsername());
        if (byUsername.isPresent()){
            throw new IllegalStateException("Username taken");
        }
}

    public void deletePerson(Long personId) {
    boolean exists = personRepository.existsById(personId);
    if (!exists){
        throw new IllegalStateException("Person with id " + personId + " does not exists");
    }
    personRepository.deleteById(personId);

    }
}
