package com.example.person_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersonManagementApplication {

	public static void main(String[] args) {
		System.out.println("DEBUG - URL: " + System.getenv("DB_URL"));
    	System.out.println("DEBUG - USER: " + System.getenv("DB_USER"));
    	System.out.println("DEBUG - PASSWORD: " + System.getenv("DB_PASSWORD"));
		SpringApplication.run(PersonManagementApplication.class, args);
	}

}
