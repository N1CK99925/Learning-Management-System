package com.example.ProductManagement;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;




@SpringBootApplication
@ComponentScan(basePackages = {"com.example.ProductManagement"})
@EnableAspectJAutoProxy

public class JwtSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtSpringBootApplication.class, args);
	}
	    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
	}
}

// Currently have deleted the project from Neon DB
