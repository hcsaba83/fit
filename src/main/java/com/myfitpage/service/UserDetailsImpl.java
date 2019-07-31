package com.myfitpage.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.myfitpage.entity.Role;
import com.myfitpage.entity.User;


public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private User user;

	public UserDetailsImpl(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		Set<Role> roles = user.getRoles();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
			System.out.println("Belépett: "+user.getFullname()+" ("+user.getUsername()+"), Authorities: "+authorities);
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		BCryptPasswordEncoder encoder = passwordEncoder();
		System.out.println("UserDetailsImpl-ben kódolt jelszó: "+encoder.encode(user.getPassword()));
		return encoder.encode(user.getPassword());
	}

	@Override
	public String getUsername() {
		return user.getUsername();
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
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

}
