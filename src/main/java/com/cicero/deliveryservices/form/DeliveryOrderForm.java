package com.cicero.deliveryservices.form;

import java.io.Serializable;
import java.util.UUID;

/**
 * Form para ser devolvido para controller
 * 
 * @author cicero
 *
 */
public class DeliveryOrderForm implements Serializable {

    /**
     * Numero serial.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Identificador da ordem de entrega.
     */
    private UUID orderId;
    /**
     * Quantidade da entrega.
     */
    private int quantity;
    /**
     * Tipo da entrega.
     */
    private String type;
    /**
     * Descrição dos produtos da entrega.
     */
    private String description;
    /**
     * Valor total da entrega.
     */
    private double total;
    /**
     * Endereco de entrega.
     */
    private String address;
    /**
     * Status da entrega.
     */
    private String status;

    public DeliveryOrderForm(UUID orderId, int quantity, String type, String description, double total, String address,
	    String status) {
	super();
	this.orderId = orderId;
	this.quantity = quantity;
	this.type = type;
	this.description = description;
	this.total = total;
	this.address = address;
	this.status = status;
    }

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
