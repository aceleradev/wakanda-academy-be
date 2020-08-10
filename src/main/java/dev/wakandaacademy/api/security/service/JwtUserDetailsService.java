package dev.wakandaacademy.api.security.service;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import dev.wakandaacademy.api.user.repository.UserRepository;

@Component
public class JwtUserDetailsService implements UserDetailsService {
	
	private UserRepository userRepository;
	
	public JwtUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		dev.wakandaacademy.api.user.model.User localUser = this.userRepository
															.findByEmail(username)
															.orElseThrow(() -> new UsernameNotFoundException(String.format("Usuario[email=%s] nao encontrado", username)));
		return new User(localUser.getEmail(), localUser.getCredential().getPassword(), Collections.emptyList());
	}

}
