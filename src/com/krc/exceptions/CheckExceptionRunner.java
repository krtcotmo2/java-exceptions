package com.krc.exceptions;

public class CheckExceptionRunner {

	public static void main(String[] args) {
		try {
			something();
			something2();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Done after 2 sec");
		}
		try {
			main2();
		} catch (Exception e) {
			e.printStackTrace();
		}
		main3();
	}



	private static void something() throws InterruptedException {
		Thread.sleep(2000);
	}

	private static void something2() {
		// thread could have an exception so if we do not throw in the method
		// declaration(as in something()) we need to wrap it in a try catch
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void something3() throws Exception {
		// thread could have an exception so if we do not throw in the method
		// declaration(as in something()) we need to wrap it in a try catch and we add a
		// throw into the catch we need to add the throw in the main method
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			throw e;
		}
	}

	private static void main2() throws Exception {
		// since something3 could throw an exception we need a try catch or a throws in
		// the main method;
		something3();
	}

	private static void main3() {
		// since something3 could throw an exception we need a try catch and since there
		// is no throw in this try catch the method fails quietly
		try {
			something3();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
