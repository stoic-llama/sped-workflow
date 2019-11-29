package edu.ccsu.sped.workflow.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.ccsu.sped.workflow.dto.UserAuthorities;

@Repository
public interface UserAuthoritiesRepository extends CrudRepository<UserAuthorities, Integer>{


}