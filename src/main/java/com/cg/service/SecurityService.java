package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Token;
import com.cg.repository.SecurityRepository;


@Service
public class SecurityService extends Token {

	@Autowired
	private SecurityRepository securityRepository;

	public String issueToken() {
		String msg;
		if(getTokenAvailable() > 0) {
			setTokenAvailable(getTokenAvailable() - 1);
			setTokenCount(getTokenCount() + 1);
			msg = "Token issued";
		}
		else {
			msg = "Parking is Full";
		}
		return msg;
	}

	public int getAllToken() {
		return getTokenCount();
	}
	
	public int getAvailableToken() {
		return getTokenAvailable();
	}
	
	public boolean isVerifySlot(String slotIssued,String slotParked) {
		if(slotIssued.equalsIgnoreCase(slotParked)) {
			return true;
		}
		return false;
	}

}
