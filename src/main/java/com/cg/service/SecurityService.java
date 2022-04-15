package com.cg.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.repository.SecurityRepository;
import com.cg.entity.*;

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
	
	public String verifySlot()
	{
		//ADD METHOD
		return null;
		
	}
	
	

}
