package edu.curso.spring.primerospasos;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PrimerosPasosApplication extends SpringBootServletInitializer {

	private static Logger log = LoggerFactory.getLogger(PrimerosPasosApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(PrimerosPasosApplication.class, args);
		log.info("Listo termmino de cargar spring boot");
	}
	
	
	//SIN ESTO NO CARGA SPRING AL GENERAR UN ARCHIVO WAR (DEPLOY EN UN TOMCAT POR EJEMPLO)
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PrimerosPasosApplication.class);
    }

}
