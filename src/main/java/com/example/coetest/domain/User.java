package com.example.coetest.domain;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class User {
	private UUID id;
	@NotNull(message = "Input username") 
	private String name;
	@Email(message = "Wrong mail format")
	private final String email;
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9].*[0-9])(?=.*[a-z]).{8}$",
		     message = "Wrong format: One uppercase, two numbers, rest must be lowercase and a maximum length of 8 characters")
	private final String password;
	private Token token;
	private List<Phones> phones;
	
	@JsonCreator
	public User(@NotNull(message = "Input user") 
	@JsonProperty("name") final String name, 
	@JsonProperty("email") final String email,
	@JsonProperty("password") final String password, 
	@JsonProperty("phones") final List<Phones> phones) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.token = new Token();
		this.phones = phones;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", token=" + token
				+ ", phones=" + phones + "]";
	}

	
}
