package com.springboot.intellij.resthibernatejpa.service;

import com.springboot.intellij.resthibernatejpa.customexception.PersonAlreadyExists;
import com.springboot.intellij.resthibernatejpa.customexception.PersonNotFoundException;
import com.springboot.intellij.resthibernatejpa.dao.PersonRepository;
import com.springboot.intellij.resthibernatejpa.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return (List<Person>) personRepository.findAll();
    }

    public Person getById(int id) {
        Optional<Person> byId = personRepository.findById(id);
        if(byId.isPresent())
            return byId.get();
        else
            throw new PersonNotFoundException();
    }

    public List<Person> getByName(String name) {
        List<Person> list = personRepository.findByFirstname(name);
        if(list.isEmpty())
            throw new PersonNotFoundException();
        return list;
    }

    public Person createPerson(@NonNull Person person) {
        if (personRepository.existsById(person.getId())) {
            throw new PersonAlreadyExists();
        }
        Person savedPerson = personRepository.save(person);
        return savedPerson;
    }

    public Person updatePerson(Person person, int id) {
        Optional<Person> byId = personRepository.findById(id);
        if(byId.isPresent())
            return personRepository.save(person);
        else
            throw new PersonNotFoundException();
    }

    public Person deletePerson(int id) {
        Optional<Person> byId = personRepository.findById(id);
        if(byId.isPresent()) {
            personRepository.deleteById(id);
            return byId.get();
        } else
            throw new PersonNotFoundException();
    }
}
