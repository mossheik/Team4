package com.cg.entity;

public class Token {
	private static int tokenCount = 0;
	private static int tokenAvailable = 0;

	public static int getTokenAvailable() {
		return tokenAvailable;
	}

	public static void setTokenAvailable(int tokenAvailable) {
		Token.tokenAvailable = tokenAvailable;
	}

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