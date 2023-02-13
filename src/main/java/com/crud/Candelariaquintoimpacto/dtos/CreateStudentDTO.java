package com.crud.Candelariaquintoimpacto.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentDTO {

    private String name;
    private String surname;
    private Integer age;

}
