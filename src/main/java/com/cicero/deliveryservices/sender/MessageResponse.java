package com.cicero.deliveryservices.sender;

/**
 * Response para ordens de entrega salvas/atualizadas.
 * @author cielo
 *
 */
public class MessageResponse {

    /**
     * Identificador da ordem de entrega.
     */
    private String orderId;

    public MessageResponse(final String orderId) {
	this.orderId = orderId;
    }

    public String getOrderId() {
	return orderId;
    }
}
