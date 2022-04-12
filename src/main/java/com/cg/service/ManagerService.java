package com.cg.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Bill;
import com.cg.entity.Customer;
import com.cg.entity.Parking;
import com.cg.repository.CustomerRepository;
import com.cg.repository.ManagerRepository;

@Service
public class ManagerService extends Parking{
	
	@Autowired
	private ManagerRepository managerRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public HashMap<Integer,String> getAllParkingPositions()
	{
		return parkingArea;
	}
	
	public HashMap<Integer, String> getAvailableParkingPositions()
	{
		HashMap<Integer,String> newMap=new HashMap<>();
		for(Map.Entry<Integer,String> m:parkingArea.entrySet()){
			if(m.getValue().equals("Vacant"))
			{
				newMap.put(m.getKey(), m.getValue());
			}
		}
		return newMap;
	}
	
	public String registerCustomer(int id)
	{
		Customer customer=customerRepository.findById(id).get();
		Bill b=new Bill();
		return b.toString()+" "+customer.toString();
		
	}
	public void generateBill()
	{
		
	}
}
