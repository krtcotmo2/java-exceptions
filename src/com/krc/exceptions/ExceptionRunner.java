package com.krc.exceptions;

public class ExceptionRunner {

	public static void main(String[] args) {
		String s = null;
		getLength(s);
	}

	private static int getLength(String s) {
		return metod2(s);
	}

	private static int metod2(String s) {
		return s.length();
	}
}
