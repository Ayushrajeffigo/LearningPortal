package com.effigo.learningPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.effigo.learningPortal.entity.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Long> {

}
