package com.matrix.examplejpaapp.repository;

import com.matrix.examplejpaapp.entity.Project;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    @Override
    @EntityGraph(attributePaths = {"student"})
    Optional<Project> findById(Integer id);

    @Override
    @EntityGraph(attributePaths = {"student"})
    List<Project> findAll();
}

