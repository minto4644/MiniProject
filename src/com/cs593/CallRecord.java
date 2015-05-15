package com.cs593;

public class CallRecord {
	private String calleeNumber;
	private String callerNumber;
	private Double callDuration;

	public CallRecord(String calleeNumber, String callerNumber, Double callDuration) {
		this.calleeNumber = calleeNumber;
		this.callerNumber = callerNumber;
		this.callDuration = callDuration;
	}
}