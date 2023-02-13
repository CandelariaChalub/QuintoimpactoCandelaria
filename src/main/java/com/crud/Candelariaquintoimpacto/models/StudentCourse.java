package com.crud.Candelariaquintoimpacto.models;

import lombok.*;

import javax.persistence.*;

@Entity @Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="student_id")
    private Student student;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;



}
