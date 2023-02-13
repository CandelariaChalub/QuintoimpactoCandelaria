package com.crud.Candelariaquintoimpacto.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity @Table(name = "teachers")
@Getter @Setter
@SuperBuilder
@NoArgsConstructor
public class Teacher extends AbstractUser{
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private int id;
    //private String name;
    //private String surname;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

    public Teacher(Integer id, String name, String surname, List<Course> courses) {
        super(id, name, surname);
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return courses.equals(teacher.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), courses);
    }
}
