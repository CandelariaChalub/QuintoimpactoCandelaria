package com.crud.Candelariaquintoimpacto.services.implement;

import com.crud.Candelariaquintoimpacto.dtos.CourseDTO;
import com.crud.Candelariaquintoimpacto.dtos.CreateTeacherDTO;
import com.crud.Candelariaquintoimpacto.dtos.TeacherDTO;
import com.crud.Candelariaquintoimpacto.models.Course;
import com.crud.Candelariaquintoimpacto.models.Teacher;
import com.crud.Candelariaquintoimpacto.repositories.TeacherRepository;
import com.crud.Candelariaquintoimpacto.services.ITeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService implements ITeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public List<TeacherDTO> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        List<TeacherDTO> teacherDTOS = new ArrayList<>();
        for(Teacher teacher : teachers){
            for(Course course : teacher.getCourses()){
                mapper.map(course, CourseDTO.class);
            }
            teacherDTOS.add(mapper.map(teacher, TeacherDTO.class));
        }
        return teacherDTOS;
    }

    @Override
    public TeacherDTO getTeacherById(Integer id) {
        return mapper.map(teacherRepository.findTeacherById(id), TeacherDTO.class);
    }

    @Override
    public TeacherDTO updateTeacher(TeacherDTO dto) {
        Teacher teacher = teacherRepository.findTeacherById(dto.getId());
        teacher.setName(dto.getName());
        teacher.setSurname(dto.getSurname());
        List<CourseDTO> courseDTOS = dto.getCourses();
        List<Course> courses = new ArrayList<>();

        for(CourseDTO courseDTO: courseDTOS){
            Course course = mapper.map(courseDTO, Course.class);
            course.setTeacher(teacher);
            courses.add(course);
        }

        teacher.setCourses(courses);
        Teacher response = teacherRepository.save(teacher);
        return mapper.map(response, TeacherDTO.class);
    }


    @Override
    public TeacherDTO saveTeacher(CreateTeacherDTO dto) {
        Teacher teacher = mapper.map(dto, Teacher.class);
        teacher.setId(null);
        List<Course> courses = new ArrayList<>();
        teacher.setCourses(courses);
        Teacher response = teacherRepository.save(teacher);
        return mapper.map(response, TeacherDTO.class);
    }

    @Transactional
    public TeacherDTO deleteTeacher(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        teacherRepository.delete(teacher);
        return mapper.map(teacher, TeacherDTO.class);
    }

   /* @Autowired
    TeacherRepository teacherRepository;

    @Override
    public TeacherDTO saveTeacher(StudentDTO dto){
        throw new RuntimeException("Missing data"),
        Student student = Course.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .teacherCourses(dto.getCourses())
                .build();
        return new TeacherDTO(teacherRepository.save(teacher));*/

}
