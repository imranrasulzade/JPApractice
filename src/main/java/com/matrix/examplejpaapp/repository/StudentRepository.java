package com.matrix.examplejpaapp.repository;

import com.matrix.examplejpaapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findByUsername(String username);

}
