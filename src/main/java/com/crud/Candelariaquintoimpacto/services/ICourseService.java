package com.crud.Candelariaquintoimpacto.services;

import com.crud.Candelariaquintoimpacto.dtos.CourseDTO;
import com.crud.Candelariaquintoimpacto.dtos.CreateCourseDTO;
import com.crud.Candelariaquintoimpacto.dtos.StudentCourseDTO;

import java.util.List;


public interface ICourseService {
    public List<CourseDTO > getAllCourses ();
    public CourseDTO getCourseById(Integer id);
    public CourseDTO saveCourse(CreateCourseDTO dto);
    public CourseDTO deleteCourse(Integer id);
    public CourseDTO updateCourse (CourseDTO dto);
    public StudentCourseDTO inscribeStudent(StudentCourseDTO dto);

}
