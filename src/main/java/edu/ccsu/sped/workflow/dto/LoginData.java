package edu.ccsu.sped.workflow.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="users")
public class LoginData {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "ldid", nullable= false)
	private Integer ldid;

	@OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_uid", referencedColumnName = "uid")
	private User user;
	
	//@OneToOne (mappedBy = "loginData")
	//private User user;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="loginData")
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<UserAuthorities> userAuthorities = new LinkedList<UserAuthorities>();
	
	@Column(nullable = false, unique = true)
	private String username;
	
	private String password;
	private boolean enabled = true;
	private Date lastLogin;
	
	private LoginData() {}
	
	public LoginData(String username, String password, User user) {
		this.username = username;
		this.password = password;
		this.user = user;
	}
	
	public Integer getLdid( ) {
		return ldid;
	}
	
	public void setLdid(Integer ldid) {
		this.ldid=ldid;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public Date getLastLogin() {
		return lastLogin;
	}
	
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	public List<UserAuthorities> getUserAuthorities() {
		return userAuthorities;
	}
	
	public void setUserAuthorities(List<UserAuthorities> userAuthorities) {
		this.userAuthorities = userAuthorities;
	}
}
