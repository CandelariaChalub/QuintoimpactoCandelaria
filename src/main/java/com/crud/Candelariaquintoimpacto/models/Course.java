package com.crud.Candelariaquintoimpacto.models;

import com.crud.Candelariaquintoimpacto.models.enums.TurnEnum;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Table
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String timetable;
    @Enumerated(EnumType.STRING)
    private TurnEnum turn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="teacher_id")
    private Teacher teacher;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<StudentCourse> studentCourses = new ArrayList<>();
}
