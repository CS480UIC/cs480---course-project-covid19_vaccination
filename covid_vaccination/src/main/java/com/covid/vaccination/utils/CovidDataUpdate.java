package com.covid.vaccination.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Callable;

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
//	@Scheduled(cron = "* * * * * ?")
	public void updateTable() throws IOException {
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
		String[] csvData = responseData.split(System.getProperty("line.separator"));
		BufferedReader lineReader = new BufferedReader( new StringReader(responseData));
		lineReader.readLine();
		 String lineText;
		while ((lineText = lineReader.readLine()) != null) {
             String[] data = lineText.split(",");
             String location = data[0];
             System.out.println(location);
             String region = data[1];
             String date = data[2];
             String location_iso = data[3];
             String region_iso = data[4];
             String total_vaccinations = data[5];
             String people_vaccinated = data[6];
             String people_fully_vaccinated = data[7];
             String total_vaccinations_per_100 = data[8];
             String people_vaccinated_per_100 = data[9];
             String people_fully_vaccinated_per_100 = data[10];
		 }
		lineReader.close();
		System.out.println(responseData);
		}
	}
