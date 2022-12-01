package com.capitole.priceservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.capitole.priceservice.controller.PriceServiceController;
import com.capitole.priceservice.model.ResponsePriceBean;
import com.capitole.priceservice.service.PricesService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;




@RunWith(SpringRunner.class)
@WebMvcTest(PriceServiceController.class)
class PriceServiceApplicationControllerLayerTests {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private PricesService pricesService;
	
	
	
	@Test
	public void contextLoads() {	
	}
	
	
	
	@Test
	public void getPriceByFechaProductoCadena_Test01_14_06_10_00() throws Exception {
		
		ResponsePriceBean responsePrice = new ResponsePriceBean();
		responsePrice.setProductId(35455);
		responsePrice.setBrandId(1);
		responsePrice.setPriceList(1);
		responsePrice.setStartDate("2020-06-14 10:00:00");
		responsePrice.setEndDate("2020-12-31 23:59:59");
		responsePrice.setFinalPrice(35.5);

		String dateApply = "2020-06-14 10:00:00";
		Integer brandApply = 1;
		Integer productApply = 35455;
		
		when(pricesService.getPriceService(
				dateApply, 
				productApply,
				brandApply)).thenReturn(responsePrice);
		
		String uri = "/getPrice?dateApply=" + dateApply + "&productId=" + productApply +
				"&brandId=" + brandApply;

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				)
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		assertNotNull(content);
		
		Integer priceListExpectedValue = 1;
		ResponsePriceBean priceBean = mapFromJson(content, ResponsePriceBean.class);
		assertEquals("La tarifa devuelta no es correcta", priceListExpectedValue, priceBean.getPriceList());

	}
	

	@Test
	public void getPriceByFechaProductoCadena_Test02_14_06_16_00() throws Exception {
		
		ResponsePriceBean responsePrice = new ResponsePriceBean();
		responsePrice.setProductId(35455);
		responsePrice.setBrandId(1);
		responsePrice.setPriceList(2);
		responsePrice.setStartDate("2020-06-14 15:00:00");
		responsePrice.setEndDate("2020-06-14 18:30:00");
		responsePrice.setFinalPrice(25.45);

		String dateApply = "2020-06-14 16:00:00";
		Integer brandApply = 1;
		Integer productApply = 35455;
		
		when(pricesService.getPriceService(
				dateApply, 
				productApply,
				brandApply)).thenReturn(responsePrice);
		
		String uri = "/getPrice?dateApply=" + dateApply + "&productId=" + productApply +
				"&brandId=" + brandApply;

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				)
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		assertNotNull(content);
		
		Integer priceListExpectedValue = 2;
		ResponsePriceBean priceBean = mapFromJson(content, ResponsePriceBean.class);
		assertEquals("La tarifa devuelta no es correcta", priceListExpectedValue, priceBean.getPriceList());

	}


	
	@Test
	public void getPriceByFechaProductoCadena_Test03_14_06_21_00() throws Exception {
		
		ResponsePriceBean responsePrice = new ResponsePriceBean();
		responsePrice.setProductId(35455);
		responsePrice.setBrandId(1);
		responsePrice.setPriceList(1);
		responsePrice.setStartDate("2020-06-14 10:00:00");
		responsePrice.setEndDate("2020-12-31 23:59:59");
		responsePrice.setFinalPrice(35.5);

		String dateApply = "2020-06-14 21:00:00";
		Integer brandApply = 1;
		Integer productApply = 35455;
		
		when(pricesService.getPriceService(
				dateApply, 
				productApply,
				brandApply)).thenReturn(responsePrice);
		
		String uri = "/getPrice?dateApply=" + dateApply + "&productId=" + productApply +
				"&brandId=" + brandApply;

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				)
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		assertNotNull(content);
		
		Integer priceListExpectedValue = 1;
		ResponsePriceBean priceBean = mapFromJson(content, ResponsePriceBean.class);
		assertEquals("La tarifa devuelta no es correcta", priceListExpectedValue, priceBean.getPriceList());

	}


	
	@Test
	public void getPriceByFechaProductoCadena_Test04_15_06_10_00() throws Exception {
		
		ResponsePriceBean responsePrice = new ResponsePriceBean();
		responsePrice.setProductId(35455);
		responsePrice.setBrandId(1);
		responsePrice.setPriceList(3);
		responsePrice.setStartDate("2020-06-15 10:00:00");
		responsePrice.setEndDate("2020-06-15 11:00:00");
		responsePrice.setFinalPrice(30.5);

		String dateApply = "2020-06-15 10:00:00";
		Integer brandApply = 1;
		Integer productApply = 35455;
		
		when(pricesService.getPriceService(
				dateApply, 
				productApply,
				brandApply)).thenReturn(responsePrice);
		
		String uri = "/getPrice?dateApply=" + dateApply + "&productId=" + productApply +
				"&brandId=" + brandApply;

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				)
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		assertNotNull(content);
		
		Integer priceListExpectedValue = 3;
		ResponsePriceBean priceBean = mapFromJson(content, ResponsePriceBean.class);
		assertEquals("La tarifa devuelta no es correcta", priceListExpectedValue, priceBean.getPriceList());

	}


	
	@Test
	public void getPriceByFechaProductoCadena_Test05_16_06_21_00() throws Exception {
		
		ResponsePriceBean responsePrice = new ResponsePriceBean();
		responsePrice.setProductId(35455);
		responsePrice.setBrandId(1);
		responsePrice.setPriceList(4);
		responsePrice.setStartDate("2020-06-15 16:00:00");
		responsePrice.setEndDate("2020-12-31 23:59:59");
		responsePrice.setFinalPrice(38.95);

		String dateApply = "2020-06-16 21:00:00";
		Integer brandApply = 1;
		Integer productApply = 35455;
		
		when(pricesService.getPriceService(
				dateApply, 
				productApply,
				brandApply)).thenReturn(responsePrice);
		
		String uri = "/getPrice?dateApply=" + dateApply + "&productId=" + productApply +
				"&brandId=" + brandApply;

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				)
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		assertNotNull(content);
		
		Integer priceListExpectedValue = 4;
		ResponsePriceBean priceBean = mapFromJson(content, ResponsePriceBean.class);
		assertEquals("La tarifa devuelta no es correcta", priceListExpectedValue, priceBean.getPriceList());

	}


	private ResponsePriceBean mapFromJson(String json, Class<ResponsePriceBean> clazz) 
			throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}
	
}
