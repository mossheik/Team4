package com.cg.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Customer;
import com.cg.entity.Manager;
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
	
	@PostMapping("/verifySlot") 
	public String verifySlot() {
		Customer c;
		if(securityService.isVerifySlot(c.getSlotNo(), c.getParkAt())) {
			return "Car parked at correct position";
		}
		return "Please park at correct position";		
	}

}
