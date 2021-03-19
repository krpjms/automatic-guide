package com.example.coetest.domain;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import lombok.Getter;

@Getter
public class UserResponse {
	private final String nombre;
	private final UUID id;
	private final Date created;
	private final Date modified;
	private final LocalDateTime lastLogin;
	private final String token;
	private final String isActive;

	public UserResponse(UUID id, Date created, Date modified, LocalDateTime lastLogin, String active, String token, String nombre) {
		this.token = token;
		this.id = id;
		this.created = created;
		this.modified = modified;
		this.lastLogin = lastLogin;
		this.isActive = active;
		this.nombre = nombre;
	}
}
