package com.covid.vaccination.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Callable;

import org.hibernate.mapping.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class CovidDataUpdate {
	
	@Autowired
	FetchData fd;
	Logger logger = LoggerFactory.getLogger(CovidDataUpdate.class);
	
	@SuppressWarnings("unused")
	@Scheduled(cron = "* * * * * ?")
	public void updateTable() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		logger.info("API call started  :: " + Calendar.getInstance().getTime());
//		JSONArray details = fd.getDetails("");		
		List<Callable<Object>> callable = new ArrayList<Callable<Object>>();
		
//		for (int i=0; i<details.size(); i++) {
//			final Object obj = details.get(i);
			callable.add(new Callable<Object>() {

				@Override
				public Object call() throws Exception {
					// TODO Auto-generated method stub
					return null;
				}
			});
//		}
		
		ResponseEntity<String> response = fd.fetchData("https://raw.githubusercontent.com/sociepy/covid19-vaccination-subnational/main/data/vaccinations.csv");
		String responseData = response.getBody();
//		Map map = mapper.convertValue(responseData, Map.class);
		System.out.println(responseData);
		}
	}
