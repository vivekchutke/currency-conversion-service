package com.example.currenncyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeServiceProxy proxyServise;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
		@RequestMapping(value= "/currency-converter/from/{from}/to/{to}/quantity/{quantity}", method = RequestMethod.GET)
		public CurrencyConverstionBean currencyConverionValue(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
			
			Map<String,String> uriVariables = new HashMap<String,String>();
			uriVariables.put("from", from);
			uriVariables.put("to", to);
			
			ResponseEntity<CurrencyConverstionBean> responseEntity = 
//					new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
//							CurrencyConverstionBean.class, uriVariables);
			
			new RestTemplate().getForEntity("https://cfexchangeservice.cfapps.io/currency-exchange/from/{from}/to/{to}", 
					CurrencyConverstionBean.class, uriVariables);
			
			CurrencyConverstionBean response = responseEntity.getBody();
			
			logger.info("**Response ",response);
			return new CurrencyConverstionBean(1l, from, to, response.getConversitionValue(), 
					quantity, quantity.multiply(response.getConversitionValue()), response.getPortNumber());

		}
		
		@RequestMapping(value= "/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}", method = RequestMethod.GET)
		public CurrencyConverstionBean currencyConverionFeignValue(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
			
			CurrencyConverstionBean response = proxyServise.retrieveExchangeValue(from, to);
			
			return new CurrencyConverstionBean(1l, from, to, response.getConversitionValue(), 
					quantity, quantity.multiply(response.getConversitionValue()), response.getPortNumber());

		}
}
