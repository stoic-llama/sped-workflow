package edu.ccsu.sped.workflow.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.ccsu.sped.workflow.dto.LoginData;
import edu.ccsu.sped.workflow.dto.User;

@Repository
public interface LoginDataRepository extends CrudRepository<LoginData, Integer>{

		LoginData findLoginDataByUser_Uid(Integer uid);

}