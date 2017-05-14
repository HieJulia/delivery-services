package com.cicero.deliveryservices.util;

import com.cicero.deliveryservices.domain.DeliveryOrder;
import com.cicero.deliveryservices.form.DeliveryOrderForm;

public abstract class OrderServiceConverter {

	public static DeliveryOrder convertFromDeliveryForm(final DeliveryOrderForm deliveryOrderForm) {
		final DeliveryOrder deliveryOrder = new DeliveryOrder(deliveryOrderForm.getOrderId(), deliveryOrderForm.getQuantity(),
				deliveryOrderForm.getType(), deliveryOrderForm.getDescription(), deliveryOrderForm.getTotal(),
				deliveryOrderForm.getAddress(), deliveryOrderForm.getStatus());
		return deliveryOrder;
	}

}