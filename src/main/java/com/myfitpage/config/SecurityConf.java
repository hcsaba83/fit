package com.myfitpage.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.myfitpage.service.UserService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConf extends WebSecurityConfigurerAdapter {
	
//	@Override
//	protected void configure(HttpSecurity httpSec) throws Exception {
//		httpSec
//				.authorizeRequests()
//					.antMatchers("/", "/**").hasAuthority("ADMIN")
//					.antMatchers("/db", "/db/**").hasAuthority("ADMIN")
//					.anyRequest().authenticated()
//					.and()
//						.formLogin().loginPage("/login").permitAll()
//						.and()
//						.logout().logoutSuccessUrl("/login?logout").permitAll();
//					
//		
//		httpSec.headers().frameOptions().disable();
//		httpSec.csrf().disable();
//	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }
	
	@Autowired
	private UserService userService;
	 
	@Bean
	public DaoAuthenticationProvider authProvider() {
	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	    authProvider.setUserDetailsService(userService);
	    authProvider.setPasswordEncoder(encoder());
	    return authProvider;
	}
	
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }

}
