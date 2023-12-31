package com.krc.exceptions;

class Amount {
	private String currency;
	private int amount;

	public Amount(String currency, int amount) {
		this.currency = currency;
		this.amount = amount;
	}

	public void addAmount(Amount newCurrency) {
		if (newCurrency.currency != currency) {
			// throw new Exception("Currency mismatch");
			String msg = "Currency symbol " + currency
					+ " does not match new currency symbol"
					+ newCurrency.currency;
			throw new CurrencyMisMatchException(msg);
		}
		this.amount += newCurrency.amount;
	}
	@Override
	public String toString() {
		return "Amount " + currency + amount;
	}

}

class CurrencyMisMatchException extends RuntimeException {
	/* */
	CurrencyMisMatchException(String msg) {
		super(msg);
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


		try {
			am1.addAmount(am4);
			String s = null;
			s.length();
		} catch (CurrencyMisMatchException e) {
			// log the exception
			e.printStackTrace();
		}
	}

}
