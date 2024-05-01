package hm.sb_xml_jdom_mvc_Homework1.dto;

import java.util.List;

public class ExchangeRatesDto {

	private List<String> ExchangeRates;

	public ExchangeRatesDto(List<String> exchangeRates) {
		super();
		ExchangeRates = exchangeRates;
	}

	public List<String> getExchangeRates() {
		return ExchangeRates;
	}

	public void setExchangeRates(List<String> exchangeRates) {
		ExchangeRates = exchangeRates;
	}

}
