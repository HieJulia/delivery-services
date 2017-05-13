package com.cicero.deliveryservices;

import java.util.concurrent.atomic.AtomicInteger;

import com.cicero.deliveryservices.domain.DeliveryOrder;

public class DeliveryOrderBuilder {
	
	public DeliveryOrder sampleDeliveryOrderBuilder() {
		DeliveryOrder deliveryOrder = new DeliveryOrder();
		AtomicInteger orderId = new AtomicInteger();
		deliveryOrder.setOrderId(new Long(orderId.incrementAndGet()));
		deliveryOrder.setQuantity(1);
		deliveryOrder.setTotal(4164.99);
		deliveryOrder.setType("ELETRO-ELETRONICO");
		deliveryOrder.setStatus("ENTREGUE");
		deliveryOrder.setDescription("Apple MacBook Air");
		return deliveryOrder;
	}

}
