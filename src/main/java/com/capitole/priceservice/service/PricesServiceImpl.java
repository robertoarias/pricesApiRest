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
	
	

	@Autowired  
	private PriceBeanRepository priceBeanRepository;



	@Override
	public ResponsePriceBean getPriceService(String dateApply, Integer productId, Integer brandId) throws ParseException {

		logger.info("\"[getPriceService] BEGIN <==");
		ResponsePriceBean responsePrice = new ResponsePriceBean();
		responsePrice.setFinalPrice(0.0);
		responsePrice.setPriceList(0);
		responsePrice.setProductId(productId);
		responsePrice.setBrandId(brandId);
		responsePrice.setStartDate("");
		responsePrice.setEndDate("");
		
		logger.info("[getPriceService] ==> fecha = " + dateApply + " / producto = " + productId + " cadena = " + brandId);
			
		dateApply = DateUtils.checkDateFormat(dateApply, " 00:00:00");
		IntegerUtils.checkIntegerFormat(productId);
		IntegerUtils.checkIntegerFormat(brandId);		
			
		List<PricesBean> priceBeanFound = priceBeanRepository.findByPrice(dateApply, productId, brandId);
		if (priceBeanFound != null) {
			logger.info("[getPriceService] ==> list size = " + priceBeanFound.size());
			priceBeanFound.forEach((price) -> {
				Integer priority = -1;
				if (price.getPriority() > priority) {
					responsePrice.setBrandId(price.getBrandId());
					responsePrice.setStartDate(price.getStartDate());
					responsePrice.setEndDate(price.getEndDate());
					responsePrice.setFinalPrice(price.getPrice());
					responsePrice.setProductId(price.getProductId());
					responsePrice.setPriceList(price.getPriceList());	
					priority = price.getPriority();
				}
			});
				
		} else {
			logger.info("[getPriceService] ==> priceBeanFound is null");				
		}

		logger.info("\"[getPriceService] END <==");
		return responsePrice;
	}
	

}
