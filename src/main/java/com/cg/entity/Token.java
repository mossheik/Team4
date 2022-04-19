package com.cg.entity;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.repository.SlotRepository;

public class Token {

	public static int tokenCount;

	public static int getTokenCount() {
		return tokenCount;
	}

	public static void setTokenCount(int tokenCount) {
		Token.tokenCount = tokenCount;
	}

}
