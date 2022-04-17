package com.cg.login;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.cg.entity.Person;
import com.cg.repository.PersonRepository;

@Component
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String email = authentication.getName();
		String password = authentication.getCredentials().toString();
		Person person = personRepository.findByEmail(email).get(0);
		System.out.println(person.toString());
		if (null != person && person.getId() > 0 && password.equals(person.getPassword())) {
			return new UsernamePasswordAuthenticationToken(person.getEmail(), password,
					getGrantedAuthorities(person.getRole()));
		} else {
			System.out.println("Bad Credential or some error");
			throw new BadCredentialsException("Invalid Credential");
		}
	}

	private Collection<? extends GrantedAuthority> getGrantedAuthorities(String role) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		return grantedAuthorities;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);

	}

}
