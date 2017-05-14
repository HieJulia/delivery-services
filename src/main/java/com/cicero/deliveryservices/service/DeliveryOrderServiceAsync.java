package com.cicero.deliveryservices.service;

import com.cicero.deliveryservices.form.DeliveryOrderForm;
import com.cicero.deliveryservices.sender.MessageResponse;

public interface DeliveryOrderServiceAsync {
	MessageResponse createOrUpdateOrder(DeliveryOrderForm order);
}
