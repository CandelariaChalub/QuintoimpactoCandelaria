package com.crud.Candelariaquintoimpacto.services.implement;

import com.crud.Candelariaquintoimpacto.dtos.CourseDTO;
import com.crud.Candelariaquintoimpacto.dtos.CreateStudentDTO;
import com.crud.Candelariaquintoimpacto.dtos.StudentCourseDTO;
import com.crud.Candelariaquintoimpacto.dtos.StudentDTO;
import com.crud.Candelariaquintoimpacto.models.Student;
import com.crud.Candelariaquintoimpacto.models.StudentCourse;
import com.crud.Candelariaquintoimpacto.repositories.CourseRepository;
import com.crud.Candelariaquintoimpacto.repositories.StudentRepository;
import com.crud.Candelariaquintoimpacto.services.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;
    ModelMapper mapper = new ModelMapper();

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student student : students) {
            StudentDTO studentDTO = mapper.map(student, StudentDTO.class);
            for (StudentCourse course : student.getCourses()) {
                StudentCourseDTO dto = mapper.map(course, StudentCourseDTO.class);
                dto.setCourse(mapper.map(courseRepository.findCourseById(course.getCourse().getId()), CourseDTO.class));
                studentDTO.setCourses(List.of(dto));
            }
            studentDTOS.add(studentDTO);
        }
        return studentDTOS;
    }

    @Override
    public StudentDTO getStudentById(Integer id) {
        return mapper.map(studentRepository.findStudentById(id), StudentDTO.class);
    }

    @Override
    public StudentDTO saveStudent(CreateStudentDTO dto) {
        Student student = mapper.map(dto, Student.class);
        student.setId(null);
        List<StudentCourse> courses = new ArrayList<>();
        student.setCourses(courses);
        Student response = studentRepository.save(student);
        return mapper.map(response, StudentDTO.class);
    }


    @Transactional
    public StudentDTO deleteStudent(Integer id) {
        Student student = studentRepository.findStudentById(id);
        studentRepository.delete(student);
        return mapper.map(student, StudentDTO.class);
    }


    @Override
    public StudentDTO updateStudent(StudentDTO dto) {
        Student student = studentRepository.findStudentById(dto.getId());
        student.setName(dto.getName());
        student.setSurname(dto.getSurname());
        student.setAge(dto.getAge());
        List<StudentCourseDTO> studentDTOS = dto.getCourses();
        List<StudentCourse> studentCourses = new ArrayList<>();

        for (StudentCourseDTO studentCourseDTO : studentDTOS) {
            StudentCourse studentCourse = mapper.map(studentCourseDTO, StudentCourse.class);
            studentCourse.setStudent(student);
            studentCourses.add(studentCourse);
        }

        student.setCourses(studentCourses);
        Student response = studentRepository.save(student);
        return mapper.map(response, StudentDTO.class);
    }

}

