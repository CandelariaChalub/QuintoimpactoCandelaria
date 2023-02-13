package com.crud.Candelariaquintoimpacto.repositories;

import com.crud.Candelariaquintoimpacto.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    public Teacher getTeacherByName(String name);
    public Teacher findTeacherById (Integer id);
}
