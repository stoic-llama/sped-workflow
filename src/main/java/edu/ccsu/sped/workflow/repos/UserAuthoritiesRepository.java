package edu.ccsu.sped.workflow.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.ccsu.sped.workflow.dto.LoginData;
import edu.ccsu.sped.workflow.dto.UserAuthorities;

@Repository
public interface UserAuthoritiesRepository extends CrudRepository<UserAuthorities, Integer>{

	List<UserAuthorities> findUserAuthoritiesByLoginData_Ldid(Integer ldid);
}