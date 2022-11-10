package edu.curso.spring.primerospasos.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import edu.curso.spring.primerospasos.PrimerosPasosApplication;

@Component
public class EmailManagerImpl implements EmailManager {

	private static Logger log = LoggerFactory.getLogger(EmailManagerImpl.class);

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	@Async
	public void enviarEmail(String destino, String mensaje) {
		log.info("Inicio del ennvio de email...");
		log.info("Destino: " + destino);
		log.info("Nensaje: " + mensaje);
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(destino);
		mailMessage.setSubject("Alta de nuevo producto");
		mailMessage.setText(mensaje);
		javaMailSender.send(mailMessage);
		log.info("Fin del ennvio de email...");		
	}
}
