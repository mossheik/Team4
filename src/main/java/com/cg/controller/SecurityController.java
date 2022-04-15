package com.cg.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/issueToken")
	public String issueToken() {
		return securityService.issueToken();
	}

	@GetMapping("/allToken")
	public int allToken() {
		return securityService.getAllToken();
	}
	
	@GetMapping("/availableToken")
	public int availableToken() {
		return securityService.getAvailableToken();
	}
	
	@GetMapping("/verifySlot/{id}") 
	public String verifySlot(@RequestParam int id) {
		CustomerRepository customerRepository;
		if(securityService.isVerifySlot(customerRepository.findById(id).get().getSlotNo(), customerRepository.findById(id).get().getParkAt())) {
			return "Car parked at correct position";
		}
		return "Please park at correct position";		
	}

}
