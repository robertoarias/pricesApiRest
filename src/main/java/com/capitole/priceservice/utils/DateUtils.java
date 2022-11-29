package com.capitole.priceservice.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public final class DateUtils {

	private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);


	public static String checkDateFormat(String fecha, String dayHour) throws ParseException {

		boolean isValid = true;
		String expReg = "^[0-9]{4}-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])";
		String expRegFull = "^[0-9]{4}-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9]) (2[0-3]|[01]?[0-9]):([0-5]?[0-9]):([0-5]?[0-9])$";

		if (fecha != null && !fecha.isEmpty()) {
			if (fecha.length() == 10) {
				try {
					if (!fecha.matches(expReg)) {
						isValid = false;
					} else {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						dateFormat.parse(fecha);
						fecha = fecha + dayHour;
					}
				} catch (Exception e) {
					isValid = false;
				}
			} else {
				if (fecha.length() == 19) {
					try {
						if (!fecha.matches(expRegFull)) {
							isValid = false;
						} else {
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							dateFormat.parse(fecha);
						}
					} catch (Exception e) {
						isValid = false;
					}
				} else {
					isValid = false;
				}
			}
		} else {
			isValid = false;
		}
		
		
		if (!isValid) {
			logger.error("[checkDateFormat] Error en formato de fecha");
			throw new ParseException("Error en Formato de fecha/hora: Parametros Invalidos", 0);
		}
		return fecha;
	}

}