package com.effigo.learningPortal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.effigo.learningPortal.dto.CategoryDto;
import com.effigo.learningPortal.dto.CourseDto;
import com.effigo.learningPortal.entity.Category;
import com.effigo.learningPortal.entity.Courses;

@Mapper(componentModel = "spring")
public interface CourseMapper {
	CourseMapper MAPPER = Mappers.getMapper(CourseMapper.class);

	Category categoryDtoToCategory(CategoryDto categoryDto);

	Courses courseDtoToCourses(CourseDto courseDto);

	Category typeToCategory(String type);

	CategoryDto categoryToCategoryDto(Category category);

	CourseDto coursesToCourseDto(Courses courses);
}
