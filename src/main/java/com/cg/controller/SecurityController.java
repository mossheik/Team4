package com.cg.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.service.SecurityService;

@RestController
public class SecurityController {

	@Autowired
	private SecurityService securityService;

	@GetMapping("/issueToken")
	public String issueToken() {
		int issuedToken = securityService.issueToken();
		if (issuedToken > 0) {
			return "Issued Token is : " + issuedToken;
		} else {
			return "Parking is Full";
		}
	}

	@GetMapping("/allToken")
	public HashMap<Integer, String> allToken() {
		return securityService.getAllToken();
	}

	@GetMapping("/availableToken")
	public HashMap<Integer, String> getAvailablePosition() {
		return securityService.getAvailableToken();
	}

}
