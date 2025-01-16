package com.example.lab1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.jdbc.Masina;
import com.example.jdbc.MasinaJdbcDao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan("com.example.jdbc")
public class Lab1Application implements CommandLineRunner{

	
	@Autowired
	MasinaJdbcDao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(Lab1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\nToate persoanele:");
		dao.findAll().forEach(System.out::println);
		
	}

}
