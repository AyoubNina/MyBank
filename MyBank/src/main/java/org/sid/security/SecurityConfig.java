package org.sid.security;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource dataSource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
	throws Exception {

	auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN", "USER");

	auth.inMemoryAuthentication().withUser("user").password("{noop}1234").roles("USER");
	}
	/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username as principal ,password as credentials,active from users where username =?")
		.authoritiesByUsernameQuery("select username as principal ,roles as role from users_role where username =?")
		.rolePrefix("ROLE_")
		.passwordEncoder(passwordEncoder());
		
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		  return new BCryptPasswordEncoder();
		 }

	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		
		web
        .ignoring()
        .antMatchers("/resources/**", "/static/**","/webjars/**","/templates/**");
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		//Strategies securite
		//Authentification basé sur un formulaire
		
		//securiser les ressources de l'application : necessitent d avoir le role user ou admin , authentification avec un role
		//erreur 403 pas autorisé
		/*http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/operations","/consultercompte").hasRole("USER").antMatchers("/saveOperation").hasRole("ADMIN")
		.and().formLogin().loginPage("/login").and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll();*/
		
/* http.formLogin().loginPage("/login");
		 
		 http.authorizeRequests().antMatchers("/operations","/consultercompte").hasRole("USER");
	
		 http.authorizeRequests().antMatchers("/saveOperation").hasRole("ADMIN");

		 http.exceptionHandling().accessDeniedPage("/403");
	}
*/

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	http.formLogin().loginPage("/login");
	http.authorizeRequests().antMatchers("/operations","/consulterCompte").hasRole("USER");
	http.authorizeRequests().antMatchers("/saveOperation").hasRole("ADMIN");
	 http.exceptionHandling().accessDeniedPage("/403");
	}

}
