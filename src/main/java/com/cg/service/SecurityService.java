package com.cg.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.repository.SecurityRepository;
import com.cg.entity.*;

@Service
public class SecurityService extends TokenClass {

	@Autowired
	private SecurityRepository securityRepository;

	public int issueToken() {
		int tokenKey = 0;
		for (Map.Entry m : token.entrySet()) {
			if (m.getValue().equals("Vacant")) {
				System.out.println(m.getKey());
				tokenKey = (int) m.getKey();
				token.replace(tokenKey, "Occupied");
				break;
			}
		}
		return tokenKey;
	}

	public HashMap<Integer, String> getAllToken() {
		return token;
	}

	public HashMap<Integer, String> getAvailableToken() {
		HashMap<Integer, String> newMap = new HashMap<>();
		for (Map.Entry<Integer, String> m : token.entrySet()) {
			if (m.getValue().equals("Vacant")) {
				newMap.put(m.getKey(), m.getValue());
			}
		}
		return newMap;
	}

	public int setToken() {
		return issueToken();
	}

}
