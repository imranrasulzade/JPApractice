package com.matrix.examplejpaapp;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.Key;

@SpringBootApplication
@RequiredArgsConstructor
public class ExampleJpaAppApplication {
	private final BCryptPasswordEncoder passwordEncoder;


	public static void main(String[] args) {
		SpringApplication.run(ExampleJpaAppApplication.class, args);

	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println(passwordEncoder.encode("teymur"));
//		System.out.println(passwordEncoder.encode("ali"));
//		System.out.println(passwordEncoder.encode("elchin"));
//		System.out.println(passwordEncoder.encode("huseyn"));
//	}
}
