package com.capitole.priceservice.service;


import java.text.ParseException;

import com.capitole.priceservice.model.ResponsePriceBean;

public interface PricesService {

	public ResponsePriceBean getPriceService(String dateApply, Integer productId, Integer brandId) throws ParseException;

}
