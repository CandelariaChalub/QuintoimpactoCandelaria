package com.crud.Candelariaquintoimpacto.controllers;
import com.crud.Candelariaquintoimpacto.dtos.CourseDTO;
import com.crud.Candelariaquintoimpacto.dtos.CreateCourseDTO;
import com.crud.Candelariaquintoimpacto.dtos.StudentCourseDTO;
import com.crud.Candelariaquintoimpacto.services.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;


@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    ICourseService courseService;


    @GetMapping("/get")
    public List<CourseDTO> getAllCourses(){
        return courseService.getAllCourses();
    }
    @Transactional
    @PostMapping("/inscription")
    public ResponseEntity<StudentCourseDTO> enrollAStudentInACourse(@RequestBody StudentCourseDTO dto){
        return new ResponseEntity<>(courseService.inscribeStudent(dto), HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Object> getCourseById(@PathVariable Integer studentId){
        return new ResponseEntity<>(courseService.getCourseById(studentId), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createCourse(@RequestBody CreateCourseDTO courseDTO){
        return new ResponseEntity<>(courseService.saveCourse(courseDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{courseId}")
    public ResponseEntity<Object> deleteCourse(@PathVariable Integer courseId){
        return new ResponseEntity<>(courseService.deleteCourse(courseId), HttpStatus.OK);
    }
    @PatchMapping("/update")
    public ResponseEntity<Object> updateCourse(@RequestBody CourseDTO dto){
        return new ResponseEntity<>(courseService.updateCourse(dto), HttpStatus.OK);
    }
}
