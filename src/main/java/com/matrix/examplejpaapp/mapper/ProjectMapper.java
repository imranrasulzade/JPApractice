package com.matrix.examplejpaapp.mapper;

import com.matrix.examplejpaapp.entity.Project;
import com.matrix.examplejpaapp.entity.Student;
import com.matrix.examplejpaapp.model.dto.ProjectDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public abstract class ProjectMapper {

    public abstract Project toProject(ProjectDto projectDto);
    @Mapping(source = "name", target = "projectName")
    @Mapping(source = "student", target = "studentFullName", qualifiedByName = "mapStudentName")
    public abstract ProjectDto toProjectDto(Project project);

    @Named("mapStudentName")
    public String mapStudentName(Student student){
        return student.getName() + " " + student.getSurname();
    }
}
