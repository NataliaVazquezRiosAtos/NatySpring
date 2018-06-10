package com.natySpring.components;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("componenteTarea")
public class TareaComponent {
	
	private static final Log MI_LOG = LogFactory.getLog(TareaComponent.class);
	
	// @Scheduled --> para hacerla repetitiva    fixedDelay=5000 --> para que se repita cada 5 segundos
	// para habilitar la repeticion poner en NatySpringApplication.java --> @EnableScheduling
	
	@Scheduled(fixedDelay=5000)
	public void hacerTarea() {
		MI_LOG.info("Fecha y hora : " + new Date());
		
	}

}
