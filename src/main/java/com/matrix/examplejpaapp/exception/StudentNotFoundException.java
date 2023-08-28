package com.matrix.examplejpaapp.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException() {
        super("Student not found!");
    }
}
