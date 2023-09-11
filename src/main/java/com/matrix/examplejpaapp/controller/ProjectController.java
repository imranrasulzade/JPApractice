package com.matrix.examplejpaapp.controller;

import com.matrix.examplejpaapp.model.dto.ProjectDto;
import com.matrix.examplejpaapp.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;
    @GetMapping("/{id}")
    public ProjectDto getStudentById(@PathVariable Integer id){
        return projectService.getProjectById(id);
    }
    @GetMapping("/")
    public List<ProjectDto> getAllProject(){
        return projectService.getAllProject();
    }

    @PostMapping("/")
    public ResponseEntity<ProjectDto> addProject(@RequestBody ProjectDto projectDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(projectService.addProject(projectDto));
    }

    @PutMapping("/")
    public ProjectDto updateProject(@RequestBody ProjectDto projectDto) {
        return projectService.updateProject(projectDto);
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteProject(@RequestBody ProjectDto projectDto) {
        projectService.deleteProject(projectDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
