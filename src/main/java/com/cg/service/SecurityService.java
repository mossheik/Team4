package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Bill;
import com.cg.entity.Customer;
import com.cg.entity.Token;
import com.cg.repository.BillRepository;
import com.cg.repository.CustomerRepository;
import com.cg.repository.SecurityRepository;
import com.cg.repository.TokenRepository;


@Service
public class SecurityService extends Token{

	@Autowired
	private SecurityRepository securityRepository;

	@Autowired
	private BillRepository billRepository;

	@Autowired
	private TokenRepository tokenRepository;

	//Get Total Available Token Count
	public String getTotalTokenCount()
	{
		Token token = tokenRepository.findById(1).get();
		return "All Available Token : "+token.getTokenCount();
	}

	//Issue Token to Customer
	public boolean issueToken()
	{
		Token token = tokenRepository.findById(1).get();
		int tokenCount=token.getTokenCount();
		
		if(tokenCount>0)
		{
			token.setTokenCount(token.getTokenCount()-1);
			tokenRepository.save(token);
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
	
	//Set Token Count if needed
		public int setToken(int tokenCount)
		{
			Token token = tokenRepository.findById(1).get();
			token.setTokenCount(tokenCount);
			tokenRepository.save(token);
			return token.getTokenCount();
		}

}
