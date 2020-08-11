package dev.wakandaacademy.api.domain.security.filter;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import dev.wakandaacademy.api.domain.security.authentication.AuthenticatedProvider;
import dev.wakandaacademy.api.domain.user.model.User;

@Service
public class AuthenticationFilter extends OncePerRequestFilter {
	
	private AuthenticatedProvider authenticatedProvider;

	public AuthenticationFilter(AuthenticatedProvider authenticatedProvider) {
		this.authenticatedProvider = authenticatedProvider;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String accessToken = this.getAccessToken(request);
		try {
			if(SecurityContextHolder.getContext().getAuthentication() == null) {
				User user = this.authenticatedProvider.getByToken(accessToken);
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = this.getAuthentication(request, user);
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		} catch (Exception e) {
			logger.error("Requisição de usuario não autenticado: " + e.getMessage());
		} finally {
			filterChain.doFilter(request, response);
		}
	}

	private String getAccessToken(HttpServletRequest request) {
		String accessToken = Optional.ofNullable(request.getHeader("Authorization"))
									.filter(authorization -> authorization.startsWith("Bearer "))
									.map(authorization -> authorization.substring(7))
									.orElse(null);
		return accessToken;
	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request, User user) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				user.getEmail(), null, Collections.emptyList());
		usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		return usernamePasswordAuthenticationToken;
	}

}
