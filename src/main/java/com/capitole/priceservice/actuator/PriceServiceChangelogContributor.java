package com.capitole.priceservice.actuator;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
import org.springframework.boot.actuate.info.Info.Builder;

@Component
public class PriceServiceChangelogContributor implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		Map<String,List<String>> changeMap = new LinkedHashMap <String,List<String>>();	
		
		List<String> v1_0_0_list= new LinkedList<String>();
		v1_0_0_list.add("Version inicial de Price Service");

		//Ultimos cambios
		changeMap.put("1.0.0 - 30/11/2022", v1_0_0_list);
		
		Map<String, Object> toShow = new HashMap<String, Object>();		
		toShow.put("Cambios", changeMap);
		builder.withDetails(toShow).build();		
		
	}
	

}