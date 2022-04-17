package com.cg.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.service.SecurityService;

@RestController
@RequestMapping(path = "/api/security")
public class SecurityController {

	@Autowired
	private SecurityService securityService;

	@GetMapping("/{securityType}/allToken")
	public String allToken(@PathVariable("securityType") String securityType) {
		if (securityType.equalsIgnoreCase("PrimarySecurity") || securityType.equalsIgnoreCase("SecondarySecurity")) {
			return securityService.getTotalTokenCount();
		} else {
			return "Security Not Available";
		}
		
	

	}

	@GetMapping("/returnHello")
	public String returnHello() {
		return "Hello";
	}
	
	@GetMapping("/setAllToken/{totalToken}")
	public int setTotalToken(@PathVariable("totalToken") int totalToken) {
		return securityService.setToken(totalToken);
	}

}
