package com.matrix.examplejpaapp.model.dto;

import com.matrix.examplejpaapp.model.StudentStatus;
import lombok.Data;

@Data
public class StudentDto {
    private Integer id;
    private String name;
    private String surname;
    private String city;
    private StudentStatus status;

}
