package com.matrix.examplejpaapp.mapper;

import com.matrix.examplejpaapp.entity.Project;
import com.matrix.examplejpaapp.entity.Student;
import com.matrix.examplejpaapp.model.dto.ProjectDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public abstract class ProjectMapper {

    @Mapping(source = "projectName", target = "name")
    public abstract Project toProject(ProjectDto projectDto);


    @Mapping(source = "name", target = "projectName")
    @Mapping(source = "student", target = "studentFullName", qualifiedByName = "mapStudentName")
    @Mapping(source = "student", target = "studentId", qualifiedByName = "mapStudentId")
    public abstract ProjectDto toProjectDto(Project project);

    @Named("mapStudentName")
    public String mapStudentName(Student student){
        if(student != null)
            return student.getName() + " " + student.getSurname();
        else
            return null;
    }

    @Named("mapStudentId")
    public Integer mapStudentId(Student student){
        if(student != null)
            return student.getId();
        else
            return null;
    }
}
