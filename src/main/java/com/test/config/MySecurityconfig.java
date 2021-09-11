package com.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.test.jwtservices.UserDetailsServiceImple;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityconfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private UserDetailsServiceImple userDetailsServiceImple; 
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(this.userDetailsServiceImple).passwordEncoder(getBCryptPasswordEncoder());
		
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable()
//		.authorizeRequests().
//		antMatchers("/authenticate", "/saveUser").
//		permitAll().
//		
//		anyRequest().authenticated().and().
//	
//		exceptionHandling().
//		authenticationEntryPoint(jwtAuthenticationEntryPoint)
//		.and()
//		.sessionManagement()
//		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		
//		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//	}
	
	
	 @Override
	 protected void configure(HttpSecurity httpSecurity) throws Exception {
	    httpSecurity
	            // we don't need CSRF because our token is invulnerable
	            .csrf().disable()


	.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and()

	            // don't create session

	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	.and()          

	            .authorizeRequests()

	            // allow anonymous resource requests
	            .antMatchers(
	                    HttpMethod.GET,
	                    "/",
	                    "/authenticate",
	                    "/saveUser",
	                    "/v2/api-docs",           // swagger
	                    "/webjars/**",            // swagger-ui webjars
	                    "/swagger-resources/**",  // swagger-ui resources
	                    "/configuration/**",      // swagger configuration
	                    "/*.html",
	                    "/favicon.ico",
	                    "/**/*.html",
	                    "/**/*.css",
	                    "/**/*.js"
	            ).permitAll()
	            .antMatchers("/euth/**","/test/**").permitAll()
	            .anyRequest().authenticated();

	    // Custom JWT based security filter
	    httpSecurity
	            .addFilterBefore(jwtRequestFilter, 
	UsernamePasswordAuthenticationFilter.class);

	    // disable page caching
	    httpSecurity.headers().cacheControl();
	}
	
	
	
	
	
	

}
