package hm.sb_xml_jdom_mvc_Homework1.controller;

import java.io.IOException;

import org.jdom2.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hm.sb_xml_jdom_mvc_Homework1.dto.ExchangeDto;
import hm.sb_xml_jdom_mvc_Homework1.dto.ExchangeRatesDto;
import hm.sb_xml_jdom_mvc_Homework1.service.AppService;

@Controller
public class AppController {

	private AppService service;

	@Autowired
	public AppController(AppService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/")
	public String getExchangeRates(Model model) throws JDOMException, IOException {
		
		ExchangeRatesDto exRates = service.getExchangeRates();
		
		model.addAttribute("rates", exRates);
		
		return "view.html";
	}
	
	
	@PostMapping("/exchange")
	public String doExchange(
			Model model,
			@RequestParam("curr") String currency,
			@RequestParam("huf") int huf
			) throws JDOMException, IOException {
		
		ExchangeRatesDto exRates = service.getExchangeRates();
		ExchangeDto exDto = service.doExchange(huf,currency);
		
		
		
		model.addAttribute("exchange",exDto);
		model.addAttribute("rates", exRates);
		
		
		return "view.html";
	}
	
	
	
	
	
	
	
}
