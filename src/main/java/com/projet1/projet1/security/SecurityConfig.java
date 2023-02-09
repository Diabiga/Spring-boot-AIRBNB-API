package com.projet1.projet1.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
public class SecurityConfig  {
 
	@Autowired
 	UserDetailsService userDetailsService;
 	
 	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
 	
 	@Autowired
 	AuthenticationManager authMgr;
	
	
 	@Bean
	public AuthenticationManager authManager(HttpSecurity http, 
			BCryptPasswordEncoder bCryptPasswordEncoder, 
			UserDetailsService userDetailsService) 
	  throws Exception {
	    return http.getSharedObject(AuthenticationManagerBuilder.class)
	      .userDetailsService(userDetailsService)
	      .passwordEncoder(bCryptPasswordEncoder)
	      .and()
	      .build();
	}


    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/anonce").hasAnyRole("R_VISITEUR","R_RESIDENCE","R_HOTEL","R_APPARTEMENT","R_VILLA","R_PISCINE","R_LOISIR","R_RESTO");
       
        http.authorizeRequests().antMatchers("/new-account").permitAll();
        http.authorizeRequests().antMatchers("/creer-anonce").permitAll();
        http.authorizeRequests().antMatchers("/all-user-config").permitAll();
        http.authorizeRequests().antMatchers("/sup-user").permitAll();
        http.authorizeRequests().antMatchers("/sup-annonce").permitAll();
        http.authorizeRequests().antMatchers("/update-user").permitAll();
        http.authorizeRequests().antMatchers("/update-anonce").permitAll();
        //http.authorizeRequests().antMatchers("/all").permitAll();
        http.authorizeRequests().antMatchers("/all").hasAuthority("ADMIN");
        http.authorizeRequests().antMatchers("/api/cat").hasAuthority("ADMIN");//CRUD
        
        http.authorizeRequests().anyRequest().authenticated();

        http.addFilter(new  JWTAuthenticationFilter(authMgr)) ;
        http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();

    }


}