package com.crud.Candelariaquintoimpacto.repositories;

import com.crud.Candelariaquintoimpacto.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findCourseById(Integer id);
    Course getCourseByName(String name);
}
