package com.krc.exceptions;

import java.util.Scanner;

public class FinallyRunner {

	public static void main(String[] args) {
		// this will throw an exception so we need to put it in a catch
		// int num = numbers[99];
		// if you do not close the scanner it can cause memory leaks
		// Scanner needs a scanner.close();

		Scanner scanner = new Scanner(System.in);
		int[] numbers = { 1, 2, 34, 5 };
		try {
			int num = numbers[99];
			System.out.println(num);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} finally {
			// finally ensures the scanner.close() gets called
			// wrap the scanner close in a null check as well for better safeguarding
			System.out.println("Closing scanner");
			if (scanner != null) {
				scanner.close();
			}
		}

	}

}
