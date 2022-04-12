package com.cg.entity;

import java.util.HashMap;

public class TokenClass {
	
	public static HashMap<Integer, String> token; 

	public TokenClass() {
		
		super();
		token = new HashMap<Integer, String>();
		token.put(1, "Occupied");
		token.put(2, "Vacant");
		token.put(3, "Vacant");
		token.put(4, "Vacant");
	}
	public TokenClass(HashMap<Integer, String> token) {
		super();
		this.token = token;
	}
	public HashMap<Integer, String> getToken() {
		return token;
	}
	public void setToken(HashMap<Integer, String> token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "TokenAbstractClass [token=" + token + "]";
	}

	
	
	
}
