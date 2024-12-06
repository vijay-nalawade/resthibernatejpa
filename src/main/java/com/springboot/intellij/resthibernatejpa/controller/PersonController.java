package com.springboot.intellij.resthibernatejpa.controller;

import com.springboot.intellij.resthibernatejpa.customexception.PersonAlreadyExists;
import com.springboot.intellij.resthibernatejpa.customexception.PersonNotFoundException;
import com.springboot.intellij.resthibernatejpa.entities.Person;
import com.springboot.intellij.resthibernatejpa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    @Qualifier("personServiceImpl")
    private PersonService personService;

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAll() {
        List<Person> allPersons = personService.getAllPersons();
        return ResponseEntity.ok(allPersons);
    }

    @GetMapping("/persons/id/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") int id) {
        Person byId = personService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @GetMapping("/persons/name/{name}")
    public ResponseEntity<List<Person>> getPersonByName(@PathVariable("name") String name) {
        List<Person> byName = personService.getByName(name);
        return ResponseEntity.ok(byName);
    }

    @PostMapping("/persons")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person servicePerson = personService.createPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(servicePerson);
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable("id") int id, @RequestBody Person person) {
        Person updatedPerson = personService.updatePerson(person, id);
        return ResponseEntity.ok(updatedPerson);
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable("id") int id) {
        Person person = personService.deletePerson(id);
        return ResponseEntity.ok(person);
    }

    @ExceptionHandler(value = PersonAlreadyExists.class)
    public ResponseEntity<String> handlePersonAlreadyExists(PersonAlreadyExists personAlreadyExists) {
        return new ResponseEntity<>("Person already exists...!!", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = PersonNotFoundException.class)
    public ResponseEntity<String> handlePersonNotFoundException(PersonNotFoundException personNotFoundException) {
        return new ResponseEntity<>("Person not found...!!", HttpStatus.CONFLICT);
    }
}
