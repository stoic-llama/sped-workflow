package edu.ccsu.sped.workflow.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="authorities")
public class UserAuthorities {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "uaid", nullable= false)
	private Integer uaid;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "login_ldid")
	@JsonBackReference
	private LoginData loginData; 
	
	@Column(nullable = false, unique = true)
	private String username;
	
	private String authority;
	
	private UserAuthorities() {}
	
	public UserAuthorities(String username, String authority) {
		this.username = username;
		this.authority = authority;
	}
	
	public UserAuthorities(String username, String authority, LoginData loginData) {
		this.username = username;
		this.authority = authority;
		this.loginData = loginData;
	}
	
	public Integer getUaid( ) {
		return uaid;
	}
	
	public void setUaid(Integer uaid) {
		this.uaid=uaid;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getAuthority() {
		return authority;
	}
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}