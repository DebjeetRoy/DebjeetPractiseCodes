package com.debjeet.spring.security.firstApp;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/*
 * Custom Authentication Provider is implemented inplace of inmemory
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
	// Written logic for User Authentication
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName();
		String password = authentication.getCredentials().toString();
		if ("tom".equals(userName) && "cruise".equals(password)) {
			return new UsernamePasswordAuthenticationToken(userName, password, Arrays.asList());
		} else
			throw new BadCredentialsException("Invalid Username or Password !!");
	}

	// This method tells Authentication Manager that MyAuthenticationProvider
	// can support UsernamePasswordAuthenticationToken type and object
	// "authentication"
	// is provided by Authentication Manager at run time and it has info of what
	// type of authentication it's looking for.
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
