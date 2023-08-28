package com.matrix.examplejpaapp.model.dto;

import lombok.Data;

@Data
public class StudentDto {
    private Integer id;
    private String name;
    private String surname;
    private String city;
    private Integer status;

}
