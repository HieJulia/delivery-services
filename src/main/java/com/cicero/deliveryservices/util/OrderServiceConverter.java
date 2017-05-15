package com.cicero.deliveryservices.util;

import com.cicero.deliveryservices.domain.DeliveryOrder;
import com.cicero.deliveryservices.form.DeliveryOrderForm;

/**
 * Converter para {@link DeliveryOrderForm} e {@link DeliveryOrderForm}
 * @author cicero
 *
 */
public abstract class OrderServiceConverter {

    /**
     * Converte um {@link DeliveryOrderForm} para {@link DeliveryOrder}
     * @param deliveryOrderForm uma ordem de entrega
     * @return {@linkDeliveryOrder} ordem de entrega convertida
     */
    public static DeliveryOrder convertFromDeliveryForm(final DeliveryOrderForm deliveryOrderForm) {
	final DeliveryOrder deliveryOrder = new DeliveryOrder(deliveryOrderForm.getOrderId(),
		deliveryOrderForm.getQuantity(), deliveryOrderForm.getType(), deliveryOrderForm.getDescription(),
		deliveryOrderForm.getTotal(), deliveryOrderForm.getAddress(), deliveryOrderForm.getStatus());
	return deliveryOrder;
    }

    /**
     * Converte um {@link DeliveryOrder} para {@link DeliveryOrderForm}
     * @param deliveryOrderForm uma ordem de entrega
     * @return {@linkDeliveryOrder} ordem de entrega convertida
     */
    public static DeliveryOrderForm convertFromDeliveryOrder(final DeliveryOrder deliveryOrder) {
	final DeliveryOrderForm deliveryOrderForm = new DeliveryOrderForm(deliveryOrder.getOrderId(),
		deliveryOrder.getQuantity(), deliveryOrder.getType(), deliveryOrder.getDescription(),
		deliveryOrder.getTotal(), deliveryOrder.getAddress(), deliveryOrder.getStatus());
	return deliveryOrderForm;
    }

}
