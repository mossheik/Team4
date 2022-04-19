package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Customer;
import com.cg.service.CustomerService;


@RestController
@RequestMapping(path = "/api/")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@PostMapping("/addCustomer")
	public String addBook(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}

	@GetMapping("/{securityType}/issueToken/{customerId}")
	public String getToken(@PathVariable("securityType") String securityType,@PathVariable("customerId") int customerId)
	{
		if(securityType.equalsIgnoreCase("ENTRY"))
		{
			return customerService.getToken(customerId);
		}else if(securityType.equalsIgnoreCase("CHECK"))
		{
			return "Only ENTRY security can issue Token!";
		}
		else {
			return "ENTRY security is not available!";
		}
		
	}
	
	@GetMapping("/selectSlot/{customerId}/{slotNo}")
	public String getToken(@PathVariable("customerId") int customerId,@PathVariable("slotNo") String slotNo)
	{
		return customerService.selectSlot(customerId, slotNo);
	}
	
	@GetMapping("/{securityType}/verifyParkingSlot/{receiptId}/{slotNo}")
	public String verifyParkingSlot(@PathVariable("securityType") String securityType,@PathVariable("receiptId") int receiptId,@PathVariable("slotNo") String slotNo)
	{
		if(securityType.equalsIgnoreCase("SecondarySecurity"))
		{
			return customerService.parkAt(receiptId, slotNo);
		}else if(securityType.equalsIgnoreCase("PrimarySecurity"))
		{
			return "Only Secondary Security can issue Token!";
		}
		else {
			return "Secondary Security is not available!";
		}
	}

}
