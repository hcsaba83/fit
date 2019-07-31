package com.myfitpage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.myfitpage.entity.User;
import com.myfitpage.service.UserDetailsImpl;
import com.myfitpage.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	public UserService() {
		super();
	}

	private UserRepository userRepository;
	
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Belépési kísérlet: " + username +" db tárolt jelszó: "+ userRepository.findByUsername(username).getPassword());
		User user = findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserDetailsImpl(user);
	}
	
	// Enélkül "java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"" hibát dob.
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

}
