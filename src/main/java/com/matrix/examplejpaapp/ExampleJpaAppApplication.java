package com.matrix.examplejpaapp;

import com.matrix.examplejpaapp.entity.Project;
import com.matrix.examplejpaapp.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.NotActiveException;

@SpringBootApplication
@RequiredArgsConstructor
public class
ExampleJpaAppApplication {

	private final ProjectRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(ExampleJpaAppApplication.class, args);


	}

//	@Override
//	public void run(String... args) throws Exception {
//		Project project = repository.findById(1).orElseThrow(NotActiveException::new);
//		System.out.println(project);
//	}
}
