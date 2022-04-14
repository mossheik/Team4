package com.cg.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.service.ManagerService;

@RestController
public class ManagerController {

	@Autowired
	private ManagerService managerService;

	@GetMapping("/allPosition")
	public HashMap<Integer, String> getAllPosition() {
		return managerService.getAllParkingPositions();
	}

	@GetMapping("/availablePos")
	public HashMap<Integer, String> getAvailablePosition() {
		return managerService.getAvailableParkingPositions();
	}

	@GetMapping("/genBill/{id}")
	public String getBill(@PathVariable("id") int id) {
		return managerService.registerCustomer(id);
	}

}
