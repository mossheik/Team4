package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Customer;
import com.cg.entity.Slot;
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
		return "Customer Added Successfully!";
	}

	//Get for Token from Primary Security
	public String getToken(int id)
	{
		//Get customer Details by customerId
		Customer customer=customerRepository.findById(id).get();
		
		if(customer.isHasToken()==false)
		{
			//Request for token to Primary Security
			if(securityService.issueToken())
			{
				//Setting Token status and Save customer
				customer.setHasToken(true);
				customerRepository.save(customer);
				
				return "Token issued Successfully! to Customer ID : "+customer.getCustomerId();
			}else
			{
				return "Token not Available, Parking is Full!";
			}
			
		}else
		{
			return "Customer Id : "+customer.getCustomerId()+" has Already issued Token!";
		}

	}

	//Customer Selects Slot
	public String selectSlot(int customerid,String slotNo)
	{
	
		if(customerRepository.existsById(customerid))
		{
			//Get Customer Details by Id
			Customer customer=customerRepository.findById(customerid).get();
		
			if(customer.isHasToken())
			{
				if(slotRepository.findBySlotNo(slotNo)!=null)
				{
					if(customer.getSlotNo()==null)
					{
						
						//Get Slot by SlotNo
						Slot s=slotRepository.findBySlotNo(slotNo);
				
						//Check Slot is 'Vacant' or Not
						if(s.getSlotStatus().toString().equalsIgnoreCase("VACANT"))
						{
							//Setting Slot
							customer.setSlotNo(slotNo);
							
							//Getting Slot and Changing Status to 'Vacant'
							Slot slot=slotRepository.findBySlotNo(slotNo);
							slot.setSlotStatus("OCCUPIED");
							
							//Save Customer
							customerRepository.save(customer);
							
							return "Slot No : "+slot.getSlotNo()+" is Alloted to "+"Customer Id : "+customer.getCustomerId();
							
						}else
						{
							return "Can not Allocate Slot! Slot is "+s.getSlotStatus();
						}
						
					}else 
					{
						return customer.getSlotNo()+" is Already Alloted to Customer Id : "+customer.getCustomerId();
					}
				}else
				{
					return "Entered Slot is wrong or Not added by ADMIN!";
				}
			}
			else
			{
				return "Hey!, "+customer.getName() + " You need to First issue Token.";
			}
		}else
		{
			return "Customer Does not Exists!";
		}

	}

	  //Verify Parked Location from Secondary Security
	  public String parkAt(int receiptId,String ParkedSlotNo) {
		  if(securityService.VerifySlot(receiptId, ParkedSlotNo))
		  {
			  return "Parked At Correct Slot";
		  }else
		  {
			  return "Parked at Wrong Slot";
		  }
	  }
	 

}
