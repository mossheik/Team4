package com.cg.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Customer;
import com.cg.entity.Manager;
import com.cg.repository.CustomerRepository;
import com.cg.service.SecurityService;

@RestController
public class SecurityController {

	@Autowired
	private SecurityService securityService;
	
	@GetMapping("/{securityType}/allToken")
	public String allToken(@PathVariable("securityType") String securityType)
	{
		if(securityType.equalsIgnoreCase("PrimarySecurity") || securityType.equalsIgnoreCase("SecondarySecurity"))
		{
			return securityService.getTotalTokenCount();
		}
		else {
			return "Security Not Available";
		}
		
	}
	
	@GetMapping("/setAllToken/{totalToken}")
	public int setTotalToken(@PathVariable("totalToken") int totalToken)
	{
		return securityService.setToken(totalToken);
	}


	

}
