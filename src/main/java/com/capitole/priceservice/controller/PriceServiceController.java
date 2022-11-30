package com.capitole.priceservice.controller;


import java.text.ParseException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capitole.priceservice.model.ResponsePriceBean;
import com.capitole.priceservice.service.PricesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RestController
@Api(tags = "Prices", produces = "application/json")
public class PriceServiceController {

	private static final Logger logger = LoggerFactory.getLogger(PriceServiceController.class);
	
	@Autowired
	PricesService pricesService;
	
	@RequestMapping(value = "isAlive", method = RequestMethod.GET)
	public ResponseEntity<String> isAlive() {
		logger.info("isAlive==>Begin");
		String resp = "OK";
		logger.info("isAlive==>End");
		return new ResponseEntity<String>(resp, HttpStatus.OK);
	}


	
    @RequestMapping(value = "getPrice", method = RequestMethod.GET)
	public ResponseEntity<ResponsePriceBean> getPrice(
	        @RequestParam(value="dateApply",required=true) String dateApply,
	        @RequestParam(value="productId",required=true) Integer productId,
	        @RequestParam(value="brandId",required=true) Integer brandId) { 

		logger.info("\"[getPrice] BEGIN <==");
		ResponsePriceBean responsePrice = new ResponsePriceBean();
		
		logger.info("getPrice==>Parametros de entrada - Fecha: " + dateApply + ", Producto: " + productId +
				", Cadena: " + brandId);
		
		try {
			responsePrice = pricesService.getPriceService(dateApply, productId, brandId);
		} catch (ParseException e) {
			logger.error("[getPrice] " + e.getMessage());
			logger.info("[getPrice] END <==");
			return new ResponseEntity<ResponsePriceBean>(responsePrice, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error("[getPrice] " + e.getMessage());
			logger.info("[getPrice] END <==");
			return new ResponseEntity<ResponsePriceBean>(responsePrice, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("[getPrice] END <==");
		return new ResponseEntity<ResponsePriceBean>(responsePrice, HttpStatus.OK);
	}

}
