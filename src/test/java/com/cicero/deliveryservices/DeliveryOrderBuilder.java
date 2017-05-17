package com.cicero.deliveryservices;

import java.util.UUID;

import com.cicero.deliveryservices.domain.DeliveryOrder;

/**
 * Builder para testes
 * @author cicero
 *
 */
public class DeliveryOrderBuilder {

    public DeliveryOrder sampleDeliveryOrderBuilder() {
	DeliveryOrder deliveryOrder = new DeliveryOrder();
	deliveryOrder.setOrderId(UUID.randomUUID());
	deliveryOrder.setQuantity(1);
	deliveryOrder.setTotal(3014.99);
	deliveryOrder.setType("ELETRO-ELETRONICO");
	deliveryOrder.setStatus("PENDENTE");
	deliveryOrder.setDescription("Geladeira 500l");
	deliveryOrder.setAddress("Avenue Third 590");
	return deliveryOrder;
    }

}
