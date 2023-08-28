package com.matrix.examplejpaapp.mapper;

import com.matrix.examplejpaapp.entity.Student;
import com.matrix.examplejpaapp.model.dto.StudentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class StudentMapper {
    public abstract StudentDto toStudentDto(Student student);

    public abstract Student toStudent(StudentDto studentDt);

}
