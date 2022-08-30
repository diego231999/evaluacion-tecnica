package com.evaluaciontecnica.servicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@SpringBootApplication

public class EvaluacionTecnica1Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(EvaluacionTecnica1Application.class, args);
	}

}
