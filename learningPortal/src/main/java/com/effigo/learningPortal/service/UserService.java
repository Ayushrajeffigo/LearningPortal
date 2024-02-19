package com.effigo.learningPortal.service;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.effigo.learningPortal.dto.LoginUserDto;
import com.effigo.learningPortal.dto.RegisterUserDto;
import com.effigo.learningPortal.entity.Role;
import com.effigo.learningPortal.entity.User;
import com.effigo.learningPortal.mapper.UserMapper;
import com.effigo.learningPortal.repository.RoleRepository;
import com.effigo.learningPortal.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserMapper userMapper;

	public boolean registerUser(RegisterUserDto registerUser) {
		Optional<Role> defaultRoleOptional = roleRepository.findByRoleType("Learner");

		if (defaultRoleOptional.isPresent()) {
			Role defaultRole = defaultRoleOptional.get();
			HashSet<Role> roles = new HashSet<>();
			roles.add(defaultRole);
			registerUser.setRoles(roles);

			User newUser = userMapper.registerUserDtoToUser(registerUser);

			try {
				userRepository.save(newUser);
				log.info("User registered successfully: {}", newUser.getEmail());
				return true;
			} catch (Exception e) {
				log.error("Failed to register user.", e);
				return false;
			}
		} else {
			log.error("Default role 'LEARNER' not found.");
			return false;
		}
	}

	public boolean loginUser(LoginUserDto loginUser) {

		try {
			User user = userRepository.findByEmail(loginUser.getEmail());
			RegisterUserDto userDetails = userMapper.userToRegisterUserDto(user);

			if (userDetails.getPassword().equals(loginUser.getPassword())) {
				log.info("User logged in successfully: {}", loginUser.getEmail());
				return true;
			} else {
				log.warn("User authentication failed for email: {}", loginUser.getEmail());
				return false;
			}
		} catch (Exception e) {
			log.error("Error occurred during user authentication.", e);
			return false;
		}
	}
}