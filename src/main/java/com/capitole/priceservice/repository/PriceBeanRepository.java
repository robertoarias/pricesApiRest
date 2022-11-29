package com.capitole.priceservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capitole.priceservice.model.PricesBean;

public interface PriceBeanRepository extends JpaRepository<PricesBean, Long> {

	@Query("SELECT t from PricesBean t where t.productId = :product AND t.brandId = :brand AND "
			+ "t.startDate <= :dateApply AND t.endDate >= :dateApply")
	public List<PricesBean> findByPrice(@Param("dateApply") String dateApply,
			@Param("product") Integer productId, @Param("brand") Integer brandId);
	
}
