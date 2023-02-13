package com.crud.Candelariaquintoimpacto.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity @Table(name = "students")
@Getter @Setter
@SuperBuilder
@NoArgsConstructor
public class Student extends AbstractUser{
    private Integer age;

    @OneToMany(mappedBy = "student", fetch= FetchType.EAGER)
    private List<StudentCourse> courses = new ArrayList<>();

    public Student(Integer id, String name, String surname, Integer age, List<StudentCourse> courses) {
        super(id, name, surname);
        this.age = age;
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return age.equals(student.age) && courses.equals(student.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), age, courses);
    }
}
