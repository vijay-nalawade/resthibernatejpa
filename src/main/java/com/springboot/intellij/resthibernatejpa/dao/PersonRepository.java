package com.springboot.intellij.resthibernatejpa.dao;

import com.springboot.intellij.resthibernatejpa.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person,Integer> {
    public List<Person> findByFirstname(String name);
}
