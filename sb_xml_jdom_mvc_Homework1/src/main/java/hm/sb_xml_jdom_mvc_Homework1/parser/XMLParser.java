package hm.sb_xml_jdom_mvc_Homework1.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import org.springframework.stereotype.Repository;

import hm.sb_xml_jdom_mvc_Homework1.model.ExchangeRates;

@Repository
public class XMLParser {

	public List<ExchangeRates> getExchangeRatesByName(String searchedCurrency) throws JDOMException, IOException {
		
		List<ExchangeRates> exRates = new ArrayList<>();
		
		SAXBuilder sb = new SAXBuilder(); 
		Document document = sb.build(new File("C:\\Users\\Marto\\OneDrive\\Dokumentumok\\Java_Hazifeladatok\\MNB_ExchangeRates.xml"));
		
		Element rootElement = document.getRootElement();
		Namespace ns = Namespace.getNamespace(rootElement.getNamespaceURI());
		
		Element dayElement = rootElement.getChild("Day", ns);
		List<Element> rateElements = dayElement.getChildren("Rate",ns);
		
		for(int index = 0; index < rateElements.size(); index++) {
			
			Element currentElement = rateElements.get(index);
			String currName = currentElement.getAttributeValue("curr");
			
			if(searchedCurrency == null || searchedCurrency.equals(currName)) {
				
				String value = currentElement.getValue();
				value = value.replace(",", ".");
				Double doublevalue = Double.parseDouble(value);
				
				ExchangeRates rate = new ExchangeRates(
						currName,
						doublevalue
						);
				exRates.add(rate);
			}
		}
		
		
		return exRates;
	}

	
	
	
	
}
