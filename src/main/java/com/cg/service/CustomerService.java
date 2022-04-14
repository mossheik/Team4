package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Customer;
import com.cg.entity.Parking;
import com.cg.entity.TokenClass;
import com.cg.repository.CustomerRepository;

@Service
public class CustomerService extends Parking {

	@Autowired
	private CustomerRepository customerRepository;

	SecurityService securityService = new SecurityService();

	public String addCustomer(Customer customer) {
		customerRepository.save(customer);
		return "Customer Added Successfully";
	}

	public int getTokenNum(int id) {

		int issuedToken = securityService.setToken();
		Customer customer = customerRepository.findById(id).get();
		customer.setTokenNumber(issuedToken);
		customerRepository.save(customer);
		return customer.getTokenNumber();
	}

	public int choosePosition(int id, int positionNum) {
		Customer customer = customerRepository.findById(id).get();
		customer.setPositionNumber(positionNum);
		parkingArea.replace(positionNum, "Occupied");
		customerRepository.save(customer);
		return customer.getPositionNumber();
	}

	public boolean setPosition() {
		return false;

	}

}
