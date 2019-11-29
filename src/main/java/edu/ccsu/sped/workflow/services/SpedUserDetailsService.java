package edu.ccsu.sped.workflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import edu.ccsu.sped.workflow.dto.AppUserPrincipal;
import edu.ccsu.sped.workflow.dto.User;
import edu.ccsu.sped.workflow.repos.LoginDataRepository;
import edu.ccsu.sped.workflow.repos.UserRepository;

@Service
public class SpedUserDetailsService implements UserDetailsService {
	 
    @Autowired
    private WebApplicationContext applicationContext;
    private UserRepository userRepository;
    private LoginDataRepository loginDataRepository;
    
    public SpedUserDetailsService() {
    	super();
    }
    
    @PostConstruct
    public void completeSetup() {
    	userRepository = applicationContext.getBean(UserRepository.class);
    }
 
    @Override
    public UserDetails loadUserByUsername(final String username) {
        final User user = userRepository.findByEmail(username);
        /*
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        */
        return new AppUserPrincipal(user);
    }
}