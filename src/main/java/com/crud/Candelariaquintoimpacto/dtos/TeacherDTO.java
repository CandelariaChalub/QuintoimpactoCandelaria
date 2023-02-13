package com.crud.Candelariaquintoimpacto.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO {
    private Integer id;
    private String name;
    private String surname;
    private List<CourseDTO> courses;

}
