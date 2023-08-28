package com.matrix.examplejpaapp.service.impl;

import com.matrix.examplejpaapp.exception.StudentNotFoundException;
import com.matrix.examplejpaapp.entity.Student;
import com.matrix.examplejpaapp.mapper.StudentMapper;
import com.matrix.examplejpaapp.model.dto.StudentDto;
import com.matrix.examplejpaapp.repository.StudentRepository;
import com.matrix.examplejpaapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    public StudentDto getStudentById(Integer id){
        return studentRepository.findById(id)
                .map(studentMapper::toStudentDto)
                .orElseThrow(StudentNotFoundException::new);
    }

    public StudentDto addStudent(StudentDto studentDto){
       Student student = studentMapper.toStudent(studentDto);
       return studentMapper.toStudentDto(studentRepository.save(student));
    }

    public StudentDto updateStudent(StudentDto studentDto){
        StudentDto existingStudent = getStudentById(studentDto.getId());
        if(existingStudent != null){
            Student student = studentMapper.toStudent(studentDto);
            return studentMapper.toStudentDto(studentRepository.save(student));
        }else
            throw new StudentNotFoundException();
    }

    public void deleteStudent(StudentDto studentDto){
        studentRepository.deleteById(studentDto.getId());
    }

    public List<StudentDto> getAllStudent() throws StudentNotFoundException{
        return studentRepository.findAll()
                .stream().map(studentMapper::toStudentDto)
                .toList();
    }
}
