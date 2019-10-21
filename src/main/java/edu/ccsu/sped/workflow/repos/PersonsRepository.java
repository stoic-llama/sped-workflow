package edu.ccsu.sped.workflow.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.ccsu.sped.workflow.models.Persons;

@Repository
public interface PersonsRepository extends CrudRepository<Persons, Integer>{

}
