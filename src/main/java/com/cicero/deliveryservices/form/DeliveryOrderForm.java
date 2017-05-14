package com.cicero.deliveryservices.form;

import java.io.Serializable;
import java.util.UUID;

public class DeliveryOrderForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UUID orderId;
	private int quantity;
	private String type;
	private String description;
	private double total;
	private String address;
	private String status;
	
	public DeliveryOrderForm() {
	}

	public UUID getOrderId() {
		return orderId;
	}

	public void setOrderId(UUID orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[DeliveryOrderForm::").append("OrderId=").append(this.orderId).append(", quantity=")
				.append(this.quantity).append(", type=").append(this.type).append(", description=")
				.append(this.description).append(", total=").append(this.total).append(", address=")
				.append(this.address).append(", status=").append(this.status).append("]");
		return sb.toString();
	}

}
