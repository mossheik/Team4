package com.cg.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.repository.SecurityRepository;
import com.cg.entity.*;

@Service
public class SecurityService extends Token {

	@Autowired
	private SecurityRepository securityRepository;

	public String issueToken() {
		setTokenCount(getTokenCount() + 1);
		return "Token issued";
	}

	public int getAllToken() {
		return getTokenCount();
	}
	
	public boolean isVerifySlot(String slotIssued,String  slotParked) {
		if(slotIssued.equalsIgnoreCase(slotParked)) {
			return true;
		}
		return false;
	}

}
