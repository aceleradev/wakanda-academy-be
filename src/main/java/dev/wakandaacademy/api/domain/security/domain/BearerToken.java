package dev.wakandaacademy.api.domain.security.domain;

import java.util.Optional;

public class BearerToken implements SecurityToken {
	
	private String token;
	
	public BearerToken(String token) {
		this.token = Optional.ofNullable(token)
							.map(tk -> tk.replace("Bearer ", ""))
							.orElse(null);
	}

	@Override
	public String getToken() {
		return this.token;
	}

}
