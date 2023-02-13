package com.crud.Candelariaquintoimpacto.services.implement;

import com.crud.Candelariaquintoimpacto.dtos.CourseDTO;
import com.crud.Candelariaquintoimpacto.dtos.CreateCourseDTO;
import com.crud.Candelariaquintoimpacto.dtos.StudentCourseDTO;
import com.crud.Candelariaquintoimpacto.models.Course;
import com.crud.Candelariaquintoimpacto.models.Student;
import com.crud.Candelariaquintoimpacto.models.StudentCourse;
import com.crud.Candelariaquintoimpacto.models.Teacher;
import com.crud.Candelariaquintoimpacto.repositories.CourseRepository;
import com.crud.Candelariaquintoimpacto.repositories.StudentCourseRepository;
import com.crud.Candelariaquintoimpacto.repositories.StudentRepository;
import com.crud.Candelariaquintoimpacto.repositories.TeacherRepository;
import com.crud.Candelariaquintoimpacto.services.ICourseService;
import com.crud.Candelariaquintoimpacto.services.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService implements ICourseService {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentCourseRepository studentCourseRepository;
    @Autowired
    IStudentService studentService;

    @Autowired
    TeacherRepository teacherRepository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        List<CourseDTO> courseDTOS = new ArrayList<>();
        for(Course course : courses){
            courseDTOS.add(mapper.map(course, CourseDTO.class));
        }
        return courseDTOS;
    }


    @Override
    public CourseDTO getCourseById(Integer id) {
        return mapper.map(courseRepository.findCourseById(id), CourseDTO.class);
    }

    @Transactional
    public CourseDTO deleteCourse(Integer id) {
        Course course = courseRepository.findCourseById(id);
        courseRepository.delete(course);
        return mapper.map(course, CourseDTO.class);
    }

    @Override
    public CourseDTO updateCourse(CourseDTO dto) {
        return null;
    }


    @Override
    public StudentCourseDTO inscribeStudent(StudentCourseDTO dto) {
        Student student = studentRepository.findStudentById(dto.getStudentId());
        Course course = courseRepository.findCourseById(dto.getCourse().getId());
        StudentCourse inscription = StudentCourse.builder()
                .course(course)
                .student(student)
                .build();
        StudentCourse studentCourse = studentCourseRepository.save(inscription);
        StudentCourseDTO response = StudentCourseDTO.builder()
                .studentId(studentCourse.getStudent().getId())
                .course(mapper.map(studentCourse.getCourse(), CourseDTO.class))
                .build();

        List<StudentCourse> courses = student.getCourses();
        List<StudentCourse> courses2 = course.getStudentCourses();

        courses.add(studentCourse);
        courses2.add(studentCourse);

        student.setCourses(courses);
        course.setStudentCourses(courses2);

        studentRepository.save(student);
        courseRepository.save(course);

        return response;
    }

    @Override
    public CourseDTO saveCourse(CreateCourseDTO dto){
        //*if (dto.getName()){ throw new RuntimeException("Missing data")}*/
        Teacher teacher = teacherRepository.findTeacherById(dto.getTeacherId());
        List<Course> courses = teacher.getCourses();
        Course course = mapper.map(dto, Course.class);
        course.setId(null);
        course.setTeacher(teacher);
        courses.add(course);
        teacher.setCourses(courses);
        teacherRepository.save(teacher);
        Course response = courseRepository.save(course);
        return mapper.map(response, CourseDTO.class);
    }

}

