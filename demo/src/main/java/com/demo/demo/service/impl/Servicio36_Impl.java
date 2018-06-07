package com.demo.demo.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.demo.demo.service.Servicio36;

@Service("servicio36")
public class Servicio36_Impl implements Servicio36{
	
	public static final Log MI_LOG = LogFactory.getLog(Servicio36_Impl.class);

	@Override
	public void mensajeLog() {
		MI_LOG.info(" -- MENSAJE DE LOG DESDE SERVICIO 36  -- ");
		
	}	
	

}
