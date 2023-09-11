package com.matrix.examplejpaapp.exception;

public class StudentNotFoundException extends NotFoundException{

    public StudentNotFoundException(){
        super("Student");
    }
}
