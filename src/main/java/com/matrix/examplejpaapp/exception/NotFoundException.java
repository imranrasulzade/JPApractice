package com.matrix.examplejpaapp.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super("Not found!");
    }
}
