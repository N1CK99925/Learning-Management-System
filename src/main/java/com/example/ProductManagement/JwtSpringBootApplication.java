package com.example.ProductManagement;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication

@EnableAspectJAutoProxy
public class JwtSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtSpringBootApplication.class, args);
	}
	
}

