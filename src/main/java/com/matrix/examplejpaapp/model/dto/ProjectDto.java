package com.matrix.examplejpaapp.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProjectDto {
    private Integer id;
    private String projectName;
    private String studentFullName;
}
