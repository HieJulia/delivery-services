package com.cicero.deliveryservices.domain;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.annotation.Id;

/**
 * Entidade para uma Ordem de entrega.
 * 
 * @author cicero
 *
 */
public class DeliveryOrder implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Indentificador da ordem.
     */
    @Id
    private UUID orderId;
    /**
     * Quantidade de produtos da entrega.
     */
    private int quantity;
    /**
     * Tipo da entrega.
     */
    private String type;
    /**
     * Descrição do produto da entrega.
     */
    private String description;
    /**
     * valor total da entrega
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

    public DeliveryOrder() {
    }

    public DeliveryOrder(UUID orderId, int quantity, String type, String description, double total, String address,
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

}
