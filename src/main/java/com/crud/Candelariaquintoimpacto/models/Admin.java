package com.crud.Candelariaquintoimpacto.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity @Table
@Getter @Setter
@SuperBuilder
public class Admin extends AbstractUser{
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private int id;
    //private String name;
    //private String surname;

}
