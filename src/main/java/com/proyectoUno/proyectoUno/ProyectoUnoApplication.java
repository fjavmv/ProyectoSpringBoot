package com.proyectoUno.proyectoUno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoUnoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoUnoApplication.class, args);
		//Errores de puerto 8080 netstat -ano | findstr LISTENING | findstr 8080
		//Detener el proceso taskkill -PID 11808 -F
	}
}
