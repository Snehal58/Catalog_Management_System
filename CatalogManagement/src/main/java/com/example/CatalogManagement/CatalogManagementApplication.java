package com.example.CatalogManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.CatalogManagement.model")
public class CatalogManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(CatalogManagementApplication.class, args);
		System.out.println("Snehal");
	}

}