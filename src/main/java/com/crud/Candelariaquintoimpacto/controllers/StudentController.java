package com.crud.Candelariaquintoimpacto.controllers;


import com.crud.Candelariaquintoimpacto.dtos.CreateStudentDTO;
import com.crud.Candelariaquintoimpacto.dtos.StudentDTO;
import com.crud.Candelariaquintoimpacto.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @GetMapping("/get")
    public List<StudentDTO> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Object> getStudentById(@PathVariable Integer courseId){
        return new ResponseEntity<>(studentService.getStudentById(courseId), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createStudent (@RequestBody CreateStudentDTO dto){
        return new ResponseEntity<>(studentService.saveStudent(dto), HttpStatus.CREATED);

    }
    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<Object> deleteStudent(@PathVariable Integer studentId){
        return new ResponseEntity<>(studentService.deleteStudent(studentId), HttpStatus.OK);
    }
    @PatchMapping("/update")
    public ResponseEntity<Object> updateStudent(@RequestBody StudentDTO dto){
        return new ResponseEntity<>(studentService.updateStudent(dto), HttpStatus.OK);
    }
}
