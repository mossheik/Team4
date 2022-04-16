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
	
	@GetMapping("/setAllToken/{totalToken}")
	public int setTotalToken(@PathVariable("totalToken") int totalToken)
	{
		return securityService.setToken(totalToken);
	}
	
	@GetMapping("/issueToken")
	public String issueToken()
	{
		boolean issuedToken=securityService.issueToken();
		if(issuedToken)
		{
			return "Issued Token is : "+issuedToken;
		}
		else
		{
			return "Parking is Full";
		}
	}

	@GetMapping("/allToken")
	public int allToken()
	{
		return securityService.getTotalTokenCount();
	}
	

}
