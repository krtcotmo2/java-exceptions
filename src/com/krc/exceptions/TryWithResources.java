package com.krc.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class TryWithResources {

	public static void main(String[] args) {
		// this will throw an exception so we need to put it in a catch
		// int num = numbers[99];
		// if you do not close the scanner it can cause memory leaks
		// Scanner needs a scanner.close();
		// by passing the scanner as an param of the try, it will auto close when t is
		// done. Done could mean success or failure.
		// Any class that implements Closeable can be an arg
		// Separate multiple values with ";"

		// Still can add a catch to handle errors

		try (Scanner scanner = new Scanner(System.in);
				FileReader fr = new FileReader(
						"src/errors.log");
				BufferedReader bf = new BufferedReader(fr)) {
			int[] numbers = { 1, 2, 34, 5 };

			int num = numbers[99];
			System.out.println(num);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
