package com.venkat.multiDatasource;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "multi database usage application proto type", version = "1.0", description = "multi database demo application"))
public class SpringMultiDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMultiDatabaseApplication.class, args);
	}

}
