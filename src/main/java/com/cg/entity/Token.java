package com.cg.entity;

public class Token {
	private static int tokenCount = 0;

	public static int getTokenCount() {
		return tokenCount;
	}

	public static void setTokenCount(int tokenCount) {
		Token.tokenCount = tokenCount;
	}

	public Token() {
		super();
	}
}