package com.crud.Candelariaquintoimpacto.repositories;

import com.crud.Candelariaquintoimpacto.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findStudentById (Integer id);
    Student findStudentByName (String name);
}
