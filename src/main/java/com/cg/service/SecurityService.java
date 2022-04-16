package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Bill;
import com.cg.entity.Customer;
import com.cg.entity.Token;
import com.cg.repository.BillRepository;
import com.cg.repository.CustomerRepository;
import com.cg.repository.SecurityRepository;


@Service
public class SecurityService extends Token{

	@Autowired
	private SecurityRepository securityRepository;

	@Autowired
	private BillRepository billRepository;

	//Set Token Count
	public int setToken(int tokenCount)
	{
		Token.setTokenCount(tokenCount);
		return Token.tokenCount;
	}

	//Get Total Available Token Count
	public String getTotalTokenCount()
	{
		return "All Available Token : "+Token.tokenCount;  
	}

	//Issue Token to Customer
	public boolean issueToken()
	{
		if(Token.tokenCount>0)
		{
			Token.tokenCount--;
			return true;
		}else
		{
			return false;
		}

	}

	//Verify Customers slotNo with Parked Position
	public boolean VerifySlot(int receiptId, String slotParked) {
		
		//Get SlotNo from Receipt by receiptId
		Bill receipt=billRepository.findById(receiptId).get();
		
		//return true if correct position or else false
		if(receipt.getSlotNo().equalsIgnoreCase(slotParked)) {
			return true;
		}else
		{
			return false;
		}
	}


}
