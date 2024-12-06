package com.springboot.intellij.resthibernatejpa.service;

import com.springboot.intellij.resthibernatejpa.customexception.PersonAlreadyExists;
import com.springboot.intellij.resthibernatejpa.customexception.PersonNotFoundException;
import com.springboot.intellij.resthibernatejpa.entities.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPersons() throws PersonNotFoundException;

    Person getById(int id) throws PersonNotFoundException;

    List<Person> getByName(String name) throws PersonNotFoundException;

    Person createPerson(Person person) throws PersonAlreadyExists;

    Person updatePerson(Person person, int id) throws PersonNotFoundException;

    Person deletePerson(int id) throws PersonNotFoundException;
}
