package edu.ccsu.sped.workflow.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.ccsu.sped.workflow.dto.User;;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	@Override
	List<User> findAll();
	
	User findByEmail(String email);
	
}
