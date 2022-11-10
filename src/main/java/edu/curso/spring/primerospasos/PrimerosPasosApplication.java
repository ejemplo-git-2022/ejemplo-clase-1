package edu.curso.spring.primerospasos;


import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableCaching
@EnableAsync
@EnableScheduling
public class PrimerosPasosApplication extends SpringBootServletInitializer {

	private static Logger log = LoggerFactory.getLogger(PrimerosPasosApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(PrimerosPasosApplication.class, args);
		log.info("Listo termmino de cargar spring boot");
	}
	
	@Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(5);
        executor.setThreadNamePrefix("ASYNC-");
        executor.initialize();
        log.info("Listo cargo el taskExecutor");
        return executor;
    }
	
	//SIN ESTO NO CARGA SPRING AL GENERAR UN ARCHIVO WAR (DEPLOY EN UN TOMCAT POR EJEMPLO)
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PrimerosPasosApplication.class);
    }

}
