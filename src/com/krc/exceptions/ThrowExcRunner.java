package com.krc.exceptions;

class Amount {
	private String currency;
	private int amount;

	public Amount(String currency, int amount) {
		this.currency = currency;
		this.amount = amount;
	}

	public void addAmount(Amount newCurrency) throws Exception {
		if (newCurrency.currency != currency) {
			throw new Exception("Currency mismatch");
		}
		this.amount += newCurrency.amount;
	}
	@Override
	public String toString() {
		return "Amount " + currency + amount;
	}

}

public class ThrowExcRunner {
	public static void main(String[] args) {
		Amount am1 = new Amount("$", 2);
		Amount am2 = new Amount("\u20ac", 3);
		Amount am3 = new Amount("\u00a3", 7);
		Amount am4 = new Amount("$", 10);
		try {
			am1.addAmount(am2);
		} catch (Exception e) {
			// log the exception
			e.printStackTrace();
		}
		System.out.println(am1);
		System.out.println(am2);
		System.out.println(am3);
		try {
			am1.addAmount(am4);
		} catch (Exception e) {
			// log the exception
			e.printStackTrace();
		}
		System.out.println(am1);
	}

}
