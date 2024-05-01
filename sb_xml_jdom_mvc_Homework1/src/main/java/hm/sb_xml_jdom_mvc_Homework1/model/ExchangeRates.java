package hm.sb_xml_jdom_mvc_Homework1.model;

public class ExchangeRates {

	private String name;
	private double value;
	
	
	public ExchangeRates(String name, double value) {
		super();
		this.name = name;
		this.value = value;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getValue() {
		return value;
	}


	public void setValue(double value) {
		this.value = value;
	}
	
}
