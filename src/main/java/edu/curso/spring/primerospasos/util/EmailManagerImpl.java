package edu.curso.spring.primerospasos.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import edu.curso.spring.primerospasos.PrimerosPasosApplication;

@Component
public class EmailManagerImpl implements EmailManager {

	private static Logger log = LoggerFactory.getLogger(EmailManagerImpl.class);

	@Override
	@Async
	public void enviarEmail(String destino, String mensaje) {
		log.info("Inicio del ennvio de email...");
		for (int i = 0; i < 10; i++) {
			log.info("Esperando... " + i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		log.info("Destino: " + destino);
		log.info("Nensaje: " + mensaje);
		log.info("Fin del ennvio de email...");		
	}
}
