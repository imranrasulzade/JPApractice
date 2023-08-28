package com.matrix.examplejpaapp.controller;

import com.matrix.examplejpaapp.model.dto.StudentDto;
import com.matrix.examplejpaapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }
    @GetMapping("/")
    public List<StudentDto> getAllStudent(){
        return studentService.getAllStudent();
    }

    @PostMapping("/")
    public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto studentDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.addStudent(studentDto));
    }

    @PutMapping("/")
    public StudentDto updateStudent(@RequestBody StudentDto studentDto) {
        return studentService.updateStudent(studentDto);
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteStudent(@RequestBody StudentDto studentDto) {
        studentService.deleteStudent(studentDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
