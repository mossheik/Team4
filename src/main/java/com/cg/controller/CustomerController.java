package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Customer;
import com.cg.service.CustomerService;


@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/addCustomer")
	public String addBook(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}

	@GetMapping("/issuedToken/{id}")
	public boolean getToken(@PathVariable("id") int id)
	{
		return customerService.getToken(id);
	}
	
	@GetMapping("/chooseSlot/{id}/{slotNo}")
	public String getToken(@PathVariable("id") int id,@PathVariable("slotNo") String slotNo)
	{
		return customerService.chooseSlot(id, slotNo);
	}

}
