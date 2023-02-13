package com.crud.Candelariaquintoimpacto.dtos;


import com.crud.Candelariaquintoimpacto.models.enums.TurnEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private Integer id;
    private String name;
    private String description;
    private String timetable;
    private TurnEnum turn;

}
