package edu.ccsu.sped.workflow.dto;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class AppUserPrincipal implements UserDetails {

    private final User user;

    //

    public AppUserPrincipal(User user) {
        this.user = user;
    }

    //

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public String getPassword() {
        return Integer.toString(user.getCcsuID());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

    	final List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("User"));
    	
    	if(user.getRole().equals("coordinator")) {
    		authorities.add(new SimpleGrantedAuthority("Admin"));
    	}
    	
    	if(user.getRole().equals("reader")) {
    		authorities.add(new SimpleGrantedAuthority("Reader"));
    	}
    	
    	if(user.getRole().equals("instructor")) {
    		authorities.add(new SimpleGrantedAuthority("Instructor"));
    	}
        
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    //

    public User getUser() {
        return user;
    }

}