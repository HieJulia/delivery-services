package com.cicero.deliveryservices.sender;

public class MessageResponse {
	
	private String orderId;
	
	public MessageResponse(final String orderId) {
		this.orderId = orderId;
	}

	public String getOrderId() {
		return orderId;
	}

}
