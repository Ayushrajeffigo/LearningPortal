package com.effigo.learningPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.effigo.learningPortal.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
