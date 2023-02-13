package com.crud.Candelariaquintoimpacto.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentCourseDTO {
    private CourseDTO course;
    private Integer studentId;
}
