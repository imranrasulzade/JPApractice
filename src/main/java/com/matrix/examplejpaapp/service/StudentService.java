package com.matrix.examplejpaapp.service;

import com.matrix.examplejpaapp.model.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
     StudentDto getStudentById(Integer id);
     StudentDto addStudent(StudentDto studentDto);
     StudentDto updateStudent(StudentDto studentDto);
     void deleteStudent(StudentDto studentDto);
     List<StudentDto> getAllStudent();


}
