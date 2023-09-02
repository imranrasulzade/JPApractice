package com.matrix.examplejpaapp.service;

import com.matrix.examplejpaapp.model.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    ProjectDto getProjectById(Integer id);
    ProjectDto addProject(ProjectDto projectDto);
    ProjectDto updateProject(ProjectDto projectDto);
    void deleteProject(ProjectDto projectDto);
    List<ProjectDto> getAllProject();
}
