package com.crud.Candelariaquintoimpacto.controllers;

import com.crud.Candelariaquintoimpacto.dtos.CreateTeacherDTO;
import com.crud.Candelariaquintoimpacto.dtos.TeacherDTO;
import com.crud.Candelariaquintoimpacto.services.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    @Autowired
    ITeacherService teacherService;

    @GetMapping("/get")
    public List<TeacherDTO> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<Object> getTeacherById(@PathVariable Integer teacherId){
        return new ResponseEntity<>(teacherService.getTeacherById(teacherId), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createTeacher (@RequestBody CreateTeacherDTO dto){
        return new ResponseEntity<>(teacherService.saveTeacher(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{teacherId}")
    public ResponseEntity<Object> deleteTeacher(@PathVariable Integer teacherId){
        return new ResponseEntity<>(teacherService.deleteTeacher(teacherId), HttpStatus.OK);
    }
    @PatchMapping("/update")
    public ResponseEntity<Object> updateTeacher(@RequestBody TeacherDTO dto){
        return new ResponseEntity<>(teacherService.updateTeacher(dto), HttpStatus.OK);
    }
}
