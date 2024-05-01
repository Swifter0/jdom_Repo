package hm.sb_xml_jdom_mvc_Homework1.dto;

public class ExchangeDto {

	private double exchange;
	private String currency;
	
	
	public ExchangeDto(double exchange, String currency) {
		super();
		this.exchange = exchange;
		this.currency = currency;
	}


	public double getExchange() {
		return exchange;
	}


	public void setExchange(double exchange) {
		this.exchange = exchange;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	@Override
	public String toString() {
		return "ExchangeDto [exchange=" + exchange + ", currency=" + currency + "]";
	}
	
}
