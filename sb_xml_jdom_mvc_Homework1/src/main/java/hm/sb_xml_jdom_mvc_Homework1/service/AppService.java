package hm.sb_xml_jdom_mvc_Homework1.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hm.sb_xml_jdom_mvc_Homework1.dto.ExchangeDto;
import hm.sb_xml_jdom_mvc_Homework1.dto.ExchangeRatesDto;
import hm.sb_xml_jdom_mvc_Homework1.model.ExchangeRates;
import hm.sb_xml_jdom_mvc_Homework1.parser.XMLParser;

@Service
public class AppService {

	private XMLParser parser;

	@Autowired
	public AppService(XMLParser parser) {
		super();
		this.parser = parser;
	}

	public ExchangeRatesDto getExchangeRates() throws JDOMException, IOException {
		
		ExchangeRatesDto exDto = null;
		
		List<ExchangeRates> exRates = parser.getExchangeRatesByName(null);
		List<String> currNames = new ArrayList<>();
		for(int index = 0; index < exRates.size(); index++) {
			
			ExchangeRates currentExRate = exRates.get(index);
			String currName = currentExRate.getName();
			currNames.add(currName);
		}

		exDto = new ExchangeRatesDto(currNames);
		
		return exDto;
	}

	public ExchangeDto doExchange(int huf, String currency) throws JDOMException, IOException {
		
		ExchangeDto exDto = null;
		List<ExchangeRates> rates = parser.getExchangeRatesByName(currency);
		
		if(rates.size() > 0) {
			
			ExchangeRates rate = rates.get(0);
			double exchangedValue = huf / rate.getValue();
			
			exDto = new ExchangeDto(exchangedValue, currency);
		}
		
		return exDto;
	}
	
	
	
	
	
}
