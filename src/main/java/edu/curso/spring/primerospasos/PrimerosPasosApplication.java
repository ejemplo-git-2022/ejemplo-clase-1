package edu.curso.spring.primerospasos;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrimerosPasosApplication {

	private static Logger log = LoggerFactory.getLogger(PrimerosPasosApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(PrimerosPasosApplication.class, args);
		log.info("Listo termmino de cargar spring boot");
	}

}
