package com.capitole.priceservice;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.capitole.priceservice.model.PricesBean;
import com.capitole.priceservice.model.ResponsePriceBean;
import com.capitole.priceservice.repository.PriceBeanRepository;
import com.capitole.priceservice.service.PricesService;




@RunWith(SpringRunner.class)
@SpringBootTest
class PriceServiceApplicationServiceLayerTests {
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	private PricesService pricesService;
	
	@MockBean
	private PriceBeanRepository priceBeanRepository;
	
	
	@Test
	public void getPriceByFechaProductoCadena_Test01_14_06_10_00() throws Exception {
		
		String dateApply = "2020-06-14 10:00:00";
		Integer brandApply = 1;
		Integer productApply = 35455;
		
		List<PricesBean> priceBeanList = new ArrayList<PricesBean>(); 
		
		PricesBean pricesBean = new PricesBean();
		pricesBean.setProductId(35455);
		pricesBean.setBrandId(1);
		pricesBean.setPriceList(1);
		pricesBean.setStartDate(LocalDateTime.parse("2020-06-14 00:00:00", formatter));
		pricesBean.setEndDate(LocalDateTime.parse("2020-12-31 23:59:59", formatter));
		pricesBean.setPrice(35.5);
		pricesBean.setPriority(0);
		
		priceBeanList.add(pricesBean);

	    Mockito.when(priceBeanRepository.findByPrice(LocalDateTime.parse(dateApply, formatter), productApply, brandApply))
	      .thenReturn(priceBeanList);  

		ResponsePriceBean priceServiceFound = pricesService.getPriceService(dateApply, productApply, brandApply);			
		Integer priceListExpectedValue = 1;
		assertEquals("La tarifa devuelta no es correcta", priceListExpectedValue, priceServiceFound.getPriceList());

	}
	

	@Test
	public void getPriceByFechaProductoCadena_Test02_14_06_16_00() throws Exception {
		
		String dateApply = "2020-06-14 16:00:00";
		Integer brandApply = 1;
		Integer productApply = 35455;
		
		List<PricesBean> priceBeanList = new ArrayList<PricesBean>(); 
		
		PricesBean pricesBean1 = new PricesBean();
		pricesBean1.setProductId(35455);
		pricesBean1.setBrandId(1);
		pricesBean1.setPriceList(1);
		pricesBean1.setStartDate(LocalDateTime.parse("2020-06-14 00:00:00", formatter));
		pricesBean1.setEndDate(LocalDateTime.parse("2020-12-31 23:59:59", formatter));
		pricesBean1.setPrice(35.5);
		pricesBean1.setPriority(0);

		priceBeanList.add(pricesBean1);

		PricesBean pricesBean2 = new PricesBean();
		pricesBean2.setProductId(35455);
		pricesBean2.setBrandId(1);
		pricesBean2.setPriceList(2);
		pricesBean2.setStartDate(LocalDateTime.parse("2020-06-14 15:00:00", formatter));
		pricesBean2.setEndDate(LocalDateTime.parse("2020-06-14 18:30:00", formatter));
		pricesBean2.setPrice(25.45);
		pricesBean2.setPriority(1);

		priceBeanList.add(pricesBean2);

	    Mockito.when(priceBeanRepository.findByPrice(LocalDateTime.parse(dateApply, formatter), productApply, brandApply))
	      .thenReturn(priceBeanList);  

		ResponsePriceBean priceServiceFound = pricesService.getPriceService(dateApply, productApply, brandApply);			
		Integer priceListExpectedValue = 2;
		assertEquals("La tarifa devuelta no es correcta", priceListExpectedValue, priceServiceFound.getPriceList());

	}


	@Test
	public void getPriceByFechaProductoCadena_Test03_14_06_21_00() throws Exception {
		
		String dateApply = "2020-06-14 21:00:00";
		Integer brandApply = 1;
		Integer productApply = 35455;
		
		List<PricesBean> priceBeanList = new ArrayList<PricesBean>(); 
		
		PricesBean pricesBean = new PricesBean();
		pricesBean.setProductId(35455);
		pricesBean.setBrandId(1);
		pricesBean.setPriceList(1);
		pricesBean.setStartDate(LocalDateTime.parse("2020-06-14 00:00:00", formatter));
		pricesBean.setEndDate(LocalDateTime.parse("2020-12-31 23:59:59", formatter));
		pricesBean.setPrice(35.5);
		pricesBean.setPriority(0);
		
		priceBeanList.add(pricesBean);

	    Mockito.when(priceBeanRepository.findByPrice(LocalDateTime.parse(dateApply, formatter), productApply, brandApply))
	      .thenReturn(priceBeanList);  

		ResponsePriceBean priceServiceFound = pricesService.getPriceService(dateApply, productApply, brandApply);			
		Integer priceListExpectedValue = 1;
		assertEquals("La tarifa devuelta no es correcta", priceListExpectedValue, priceServiceFound.getPriceList());

	}

	
	
	@Test
	public void getPriceByFechaProductoCadena_Test04_15_06_10_00() throws Exception {
		
		String dateApply = "2020-06-15 10:00:00";
		Integer brandApply = 1;
		Integer productApply = 35455;
		
		List<PricesBean> priceBeanList = new ArrayList<PricesBean>(); 
		
		PricesBean pricesBean1 = new PricesBean();
		pricesBean1.setProductId(35455);
		pricesBean1.setBrandId(1);
		pricesBean1.setPriceList(1);
		pricesBean1.setStartDate(LocalDateTime.parse("2020-06-14 00:00:00", formatter));
		pricesBean1.setEndDate(LocalDateTime.parse("2020-12-31 23:59:59", formatter));
		pricesBean1.setPrice(35.5);
		pricesBean1.setPriority(0);

		priceBeanList.add(pricesBean1);

		PricesBean pricesBean2 = new PricesBean();
		pricesBean2.setProductId(35455);
		pricesBean2.setBrandId(1);
		pricesBean2.setPriceList(3);
		pricesBean2.setStartDate(LocalDateTime.parse("2020-06-15 00:00:00", formatter));
		pricesBean2.setEndDate(LocalDateTime.parse("2020-06-15 11:00:00", formatter));
		pricesBean2.setPrice(30.50);
		pricesBean2.setPriority(1);

		priceBeanList.add(pricesBean2);

	    Mockito.when(priceBeanRepository.findByPrice(LocalDateTime.parse(dateApply, formatter), productApply, brandApply))
	      .thenReturn(priceBeanList);  

		ResponsePriceBean priceServiceFound = pricesService.getPriceService(dateApply, productApply, brandApply);			
		Integer priceListExpectedValue = 3;
		assertEquals("La tarifa devuelta no es correcta", priceListExpectedValue, priceServiceFound.getPriceList());

	}

	
	
	@Test
	public void getPriceByFechaProductoCadena_Test05_16_06_21_00() throws Exception {
		
		String dateApply = "2020-06-16 21:00:00";
		Integer brandApply = 1;
		Integer productApply = 35455;
		
		List<PricesBean> priceBeanList = new ArrayList<PricesBean>(); 
		
		PricesBean pricesBean1 = new PricesBean();
		pricesBean1.setProductId(35455);
		pricesBean1.setBrandId(1);
		pricesBean1.setPriceList(1);
		pricesBean1.setStartDate(LocalDateTime.parse("2020-06-14 00:00:00", formatter));
		pricesBean1.setEndDate(LocalDateTime.parse("2020-12-31 23:59:59", formatter));
		pricesBean1.setPrice(35.5);
		pricesBean1.setPriority(0);

		priceBeanList.add(pricesBean1);

		PricesBean pricesBean2 = new PricesBean();
		pricesBean2.setProductId(35455);
		pricesBean2.setBrandId(1);
		pricesBean2.setPriceList(4);
		pricesBean2.setStartDate(LocalDateTime.parse("2020-06-15 16:00:00", formatter));
		pricesBean2.setEndDate(LocalDateTime.parse("2020-12-31 23:59:59", formatter));
		pricesBean2.setPrice(38.95);
		pricesBean2.setPriority(1);

		priceBeanList.add(pricesBean2);

	    Mockito.when(priceBeanRepository.findByPrice(LocalDateTime.parse(dateApply, formatter), productApply, brandApply))
	      .thenReturn(priceBeanList);  

		ResponsePriceBean priceServiceFound = pricesService.getPriceService(dateApply, productApply, brandApply);			
		Integer priceListExpectedValue = 4;
		assertEquals("La tarifa devuelta no es correcta", priceListExpectedValue, priceServiceFound.getPriceList());

	}

}
