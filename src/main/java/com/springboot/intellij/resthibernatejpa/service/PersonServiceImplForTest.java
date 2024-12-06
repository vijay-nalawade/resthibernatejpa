package com.springboot.intellij.resthibernatejpa.service;

import com.springboot.intellij.resthibernatejpa.customexception.PersonAlreadyExists;
import com.springboot.intellij.resthibernatejpa.customexception.PersonNotFoundException;
import com.springboot.intellij.resthibernatejpa.entities.Person;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonServiceImplForTest implements PersonService{
    @Override
    public List<Person> getAllPersons() throws PersonNotFoundException {
        return null;
    }

    @Override
    public Person getById(int id) throws PersonNotFoundException {
        return null;
    }

    @Override
    public List<Person> getByName(String name) throws PersonNotFoundException {
        return null;
    }

    @Override
    public Person createPerson(Person person) throws PersonAlreadyExists {
        return null;
    }

    @Override
    public Person updatePerson(Person person, int id) throws PersonNotFoundException {
        return null;
    }

    @Override
    public Person deletePerson(int id) throws PersonNotFoundException {
        return null;
    }
}
