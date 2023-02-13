package com.crud.Candelariaquintoimpacto.services;

import com.crud.Candelariaquintoimpacto.dtos.CreateTeacherDTO;
import com.crud.Candelariaquintoimpacto.dtos.TeacherDTO;

import java.util.List;

public interface ITeacherService {
    public List<TeacherDTO> getAllTeachers();
    public TeacherDTO getTeacherById(Integer id);
    public TeacherDTO updateTeacher(TeacherDTO dto);
    public TeacherDTO saveTeacher(CreateTeacherDTO dto);
    public TeacherDTO deleteTeacher(Integer id);
}
