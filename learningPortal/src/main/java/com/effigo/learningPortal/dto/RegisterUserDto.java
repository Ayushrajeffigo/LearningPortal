package com.effigo.learningPortal.dto;

import java.util.Set;

import com.effigo.learningPortal.entity.Courses;
import com.effigo.learningPortal.entity.Role;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RegisterUserDto {
	@JsonProperty("name")
	private String name;

	@JsonProperty("email")
	private String email;

	@JsonProperty("password")
	private String password;

	private Set<Role> roles;

	private Set<Courses> courses;
}