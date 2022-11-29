package com.capitole.priceservice.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public final class IntegerUtils {

	private static final Logger logger = LoggerFactory.getLogger(IntegerUtils.class);

	public static void checkIntegerFormat(Integer value) throws ParseException {

		if (value == null || value <= 0) {
			logger.error("[checkIntegerFormat] Error en formato de valor entero");
			throw new ParseException("Error en Formato de valor entero: Parametros Invalidos", 0);
		}	
	}

}