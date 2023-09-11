package com.matrix.examplejpaapp.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String ex) {
        super(ex + " Not found!");
    }
}
