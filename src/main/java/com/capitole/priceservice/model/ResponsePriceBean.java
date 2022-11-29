package com.capitole.priceservice.model;


import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/*
 * Clase que representa la respuesta hacia el usuario
 * */
@Component
@JsonPropertyOrder({ "productId","brandId", "priceList", "startDate", "endDate", "finalPrice", "responseCode"})
public class ResponsePriceBean {
	
	private Integer productId;
	private Integer brandId;
	private Integer priceList;
	private String startDate;
	private String endDate;
	private Double finalPrice;
	
	public ResponsePriceBean() {		
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public Integer getPriceList() {
		return priceList;
	}

	public void setPriceList(Integer priceList) {
		this.priceList = priceList;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}
	
		
}
