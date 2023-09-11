package com.matrix.examplejpaapp.exception;

public class ProjectNotFoundException extends NotFoundException{
    public ProjectNotFoundException() {
        super("Project");
    }
}
