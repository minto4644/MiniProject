package com.cs593;

public class Subscriber {
	private String phoneNumber;
	private Double balance;

	public Subscriber(String phoneNumber, Double balance) {
		this.phoneNumber = phoneNumber;
		this.balance = balance;
	}

	public Subscriber(String phoneNumber) {
		this(phoneNumber, 0.0);
	}

	public Subscriber Call(Double duration) throws Exception {
		Double charge = duration * Tarrif.get();
		if (this.balance <= 0 || this.balance < charge)
			throw new Exception("Insufficient account balance");
		this.balance -= charge;
		return this;
	}

	public Subscriber Recharge(Double amount) throws Exception {
		if (amount <= 0)
			throw new Exception("Amount must be positive");
		this.balance += amount;
		return this;
	}

	public Double getBalance() {
		return this.balance;
	}
}