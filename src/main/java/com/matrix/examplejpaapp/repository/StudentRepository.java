package com.matrix.examplejpaapp.repository;

import com.matrix.examplejpaapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
