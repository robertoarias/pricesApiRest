package com.capitole.priceservice.service;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capitole.priceservice.model.PricesBean;
import com.capitole.priceservice.model.ResponsePriceBean;
import com.capitole.priceservice.repository.PriceBeanRepository;
import com.capitole.priceservice.utils.DateUtils;
import com.capitole.priceservice.utils.IntegerUtils;


@Service
public class PricesServiceImpl implements PricesService {

	
	private static final Logger logger = LoggerFactory.getLogger(PricesServiceImpl.class);
	
	


	@Override
	public ResponsePriceBean getPriceService(String fecha, Integer producto, Integer cadena) throws ParseException {
		// TODO Auto-generated method stub
		return null;
	}


}
