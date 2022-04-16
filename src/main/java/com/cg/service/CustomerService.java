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

	//Add Customer
	public String addCustomer(Customer customer)
	{
		customerRepository.save(customer);
		return "Customer Added Successfully";
	}

	//Get for Token from Primary Security
	public String getToken(int id)
	{
		//Get customer Details by customerId
		Customer customer=customerRepository.findById(id).get();
		
		//Request for token to Primary Security
		if(securityService.issueToken())
		{
			//Setting Token status and Save customer
			customer.setHasToken(true);
			customerRepository.save(customer);
			
			return "Token issued to "+ customer.getCustomerId();
		}else
		{
			return "Token not Available, Parking is Full!";
		}

	}

	//Customer Selects Slot
	public String selectSlot(int customerid,String slotNo)
	{
		//Get Customer Details by Id
		Customer customer=customerRepository.findById(customerid).get();

		//Get Slot by SlotNo
		Slot s=slotRepository.findBySlotNo(slotNo);

		//Check Slot is 'Vacant' or Not
		if(s.getSlotStatus().equalsIgnoreCase("Vacant"))
		{
			//Setting Slot
			customer.setSlotNo(slotNo);
			
			//Getting Slot and Changing Status to 'Vacant'
			Slot slot=slotRepository.findBySlotNo(slotNo);
			slot.setSlotStatus("Occupied");
			
			//Save Customer
			customerRepository.save(customer);
			
			return customer.getCustomerId()+" is Alloted to "+slot.getSlotNo();
			
		}else
		{
			return "Slot is "+s.getSlotStatus();
		}

	}

	  //Verify Parked Location from Secondary Security
	  public String parkAt(int receiptId,String ParkedSlotNo) {
		  if(securityService.VerifySlot(receiptId, ParkedSlotNo))
		  {
			  return "Parked At Correct Slot";
		  }else
		  {
			  return "Parked Wrong Slot";
		  }
	  }
	 

}
