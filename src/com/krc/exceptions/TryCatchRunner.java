package com.krc.exceptions;

public class TryCatchRunner {

	public static void main(String[] args) {
		String s = null;
		method1(s);
		System.out.println("DONE MAIN");
	}

	private static void method1(String s) {
		try {
			metod2(s);
			System.out.println("DONE METHOD 1");
		} catch (Exception e) {
			System.out.println("Error in mothod1");
			e.printStackTrace();
		}
	}

	private static void metod2(String s) {
		try {
			// s.length();
			int[] i = { 1, 2 };
			int num = i[2];
			System.out.println("DONE METHOD 2 " + num);
		} catch (NullPointerException e) {
			System.out.println("NULL POINTER Error in method2");
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index Out Of Bounds Exception");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("REGULAR EXCEPTION Error in mothod2");
			e.printStackTrace();
		}
		System.out.println("METHOD 2 After block");
	}
}
