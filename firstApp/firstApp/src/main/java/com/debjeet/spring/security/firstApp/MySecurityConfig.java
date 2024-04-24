package com.debjeet.spring.security.firstApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class MySecurityConfig {

	// Customize User Details Service
//	@Bean
//	UserDetailsService userDetailsService() {
//		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//		UserDetails user = User.withUsername("tom").password(passwordEncoder().encode("cruise")).authorities("read")
//				.build();
//		userDetailsService.createUser(user);
//		return userDetailsService;
//	}

	// When we will try to login again, Spring boot will automatically use this
	// Password Encoder
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Customize and configures security of our application.(Basic Authentication)
//	@Bean
//	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.httpBasic(Customizer.withDefaults());
//		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
//		return http.build(); // returns default SecurityChain
//	}

	// Form based authentication
//	@Bean
//	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.formLogin();
//		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
//		return http.build(); // returns default SecurityChain
//	}

	// Access only hello endpoint
//	@Bean
//	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.formLogin();
//		http.authorizeHttpRequests(auth -> auth.requestMatchers("/hello").authenticated().anyRequest().denyAll());
//		return http.build(); // returns default SecurityChain
//	}

	// Configuration for Custom Filter
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.httpBasic(Customizer.withDefaults());
		http.authorizeHttpRequests(auth -> auth.requestMatchers("/hello").authenticated());
		http.addFilterBefore(new MySecurityFilter(), BasicAuthenticationFilter.class);
		return http.build(); // returns default SecurityChain
	}
}
