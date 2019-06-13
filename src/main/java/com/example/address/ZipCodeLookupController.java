package com.example.address;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController	
public class ZipCodeLookupController {
	private RestTemplate restTemplate = new RestTemplate();
	private static final String serviceUrl="https://www.zipcodeapi.com/rest/FnbUYOeLmQ7pXOkNkMzTP0o5o78XTt3st84ieHp3MtftKCm69sBwXtNNa4HfhmBv/info.json/";
	
	@RequestMapping("/location/{zipCode}/")
	public Location lookup(@PathVariable(value="zipCode") String zip) {
		ResponseEntity<Location> response
		  = restTemplate.getForEntity(serviceUrl + zip+"/degrees", Location.class);
		return response.getBody();		
	}
	
	public static class Location implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String city;
		private String state;
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		
		
	}

}	
