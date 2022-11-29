package com.capitole.priceservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



/*Clase que mapea la tabla PRICES*/		
@Entity
@Table(name="PRICES")
public class PricesBean implements Serializable {

		private static final long serialVersionUID = 1L;
	
		@Id
		@Column(name = "ID")
		private long id;

		@Column(name = "BRAND_ID")
		private Integer brandId;

		@Column(name = "START_DATE")
		private String startDate;

		@Column(name = "END_DATE")
		private String endDate;
		
		@Column(name = "PRICE_LIST")
		private Integer priceList;
		
		@Column(name = "PRODUCT_ID")
		private Integer productId;
		
		@Column(name = "PRIORITY")
		private Integer priority;
		
		@Column(name = "PRICE")
		private Double price;
		
		@Column(name = "CURR")
		private String curr;
		
		
		public PricesBean() {
		}


		public Integer getBrandId() {
			return brandId;
		}


		public void setBrandId(Integer brandId) {
			this.brandId = brandId;
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


		public Integer getPriceList() {
			return priceList;
		}


		public void setPriceList(Integer priceList) {
			this.priceList = priceList;
		}


		public Integer getProductId() {
			return productId;
		}


		public void setProductId(Integer productId) {
			this.productId = productId;
		}


		public Integer getPriority() {
			return priority;
		}


		public void setPriority(Integer priority) {
			this.priority = priority;
		}


		public Double getPrice() {
			return price;
		}


		public void setPrice(Double price) {
			this.price = price;
		}


		public String getCurr() {
			return curr;
		}


		public void setCurr(String curr) {
			this.curr = curr;
		}


		
}
