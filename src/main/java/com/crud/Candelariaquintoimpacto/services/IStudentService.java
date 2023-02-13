package com.crud.Candelariaquintoimpacto.services;

import com.crud.Candelariaquintoimpacto.dtos.CreateStudentDTO;
import com.crud.Candelariaquintoimpacto.dtos.StudentDTO;

import java.util.List;

public interface IStudentService {
    public List<StudentDTO> getAllStudents();
    public StudentDTO getStudentById(Integer id);
    public StudentDTO saveStudent(CreateStudentDTO dto);
    public StudentDTO deleteStudent(Integer id);
    public StudentDTO updateStudent (StudentDTO dto);

}
