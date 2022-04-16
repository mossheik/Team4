package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Token;
import com.cg.repository.SecurityRepository;


@Service
public class SecurityService extends Token{
	
	@Autowired
	private SecurityRepository securityRepository;
	
	public int setToken(int tokenCount)
	{
		Token.setTokenCount(tokenCount);
		return Token.tokenCount;
	}
	
	public int getTotalTokenCount()
	{
		return Token.tokenCount;  
	}
	
	public boolean issueToken()
	{
		Token.tokenCount--;
		return true;
	}
	
	public String isVerifySlot(String slotIssued,String slotParked) {
		if(slotIssued.equalsIgnoreCase(slotParked)) {
			return "Parked Correct Position";
		}
		return "Park At Wrong Position";
	}
	

}
