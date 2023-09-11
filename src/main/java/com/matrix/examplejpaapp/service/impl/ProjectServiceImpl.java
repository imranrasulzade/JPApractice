package com.matrix.examplejpaapp.service.impl;

import com.matrix.examplejpaapp.entity.Project;
import com.matrix.examplejpaapp.entity.Student;
import com.matrix.examplejpaapp.exception.ProjectNotFoundException;
import com.matrix.examplejpaapp.mapper.ProjectMapper;
import com.matrix.examplejpaapp.model.dto.ProjectDto;
import com.matrix.examplejpaapp.repository.ProjectRepository;
import com.matrix.examplejpaapp.repository.StudentRepository;
import com.matrix.examplejpaapp.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final StudentRepository studentRepository;
    private final ProjectMapper projectMapper;
    @Override
    public ProjectDto getProjectById(Integer id) {
        return projectRepository.findById(id)
                .map(projectMapper::toProjectDto)
                .orElseThrow(ProjectNotFoundException::new);
    }

    @Override
    public ProjectDto addProject(ProjectDto projectDto) {
        //Student student = studentRepository.findById(projectDto.getStudentId()).orElseThrow(NotFoundException::new);
        Project project = projectMapper.toProject(projectDto);
        //project.setStudent(student);
        return projectMapper.toProjectDto(projectRepository.save(project));
    }

    @Override
    public ProjectDto updateProject(ProjectDto projectDto) {
        Student student = studentRepository.findById(projectDto.getStudentId()).orElseThrow(ProjectNotFoundException::new);
        Project project = projectMapper.toProject(projectDto);
        project.setStudent(student);
        return projectMapper.toProjectDto(projectRepository.save(project));
    }

    @Override
    public void deleteProject(ProjectDto projectDto) {
        Project project = projectMapper.toProject(projectDto);
        projectRepository.deleteById(project.getId());
    }

    @Override
    public List<ProjectDto> getAllProject() {
        return projectRepository.findAll().stream()
                .map(projectMapper::toProjectDto)
                .toList();
    }
}
