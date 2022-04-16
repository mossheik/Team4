package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Customer;
import com.cg.entity.Slot;
import com.cg.entity.Token;
import com.cg.repository.CustomerRepository;
import com.cg.repository.SlotRepository;

@Service
public class CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private SlotRepository slotRepository;
	
	SecurityService securityService=new SecurityService();
	
	public String addCustomer(Customer customer)
	{
		customerRepository.save(customer);
		return "Customer Added Successfully";
	}
	
	public boolean getToken(int id)
	{
		Customer customer=customerRepository.findById(id).get();
		customer.setHasToken(true);
		Token.tokenCount--;
		customerRepository.save(customer);
		return customer.isHasToken();
	}
	
	public String chooseSlot(int id,String slotNo)
	{
		Customer customer=customerRepository.findById(id).get();
		Slot s=slotRepository.findBySlotNo(slotNo);
		if(s.getSlotStatus().equalsIgnoreCase("Vacant"))
		{
			customer.setSlotNo(slotNo);
			Slot slot=slotRepository.findBySlotNo(slotNo);
			slot.setSlotStatus("Occupied");
			customerRepository.save(customer);
			return customer.getCustomerId()+" is Alloted to "+slot.getSlotNo();
		}else
		{
			return "Slot is "+s.getSlotStatus();
		}
		
	}

	/*
	 * public String parkAt() {
	 * 
	 * }
	 */
	public boolean setPosition() {
		return false;

	}

}
