package com.cicero.deliveryservices.service;

import java.util.List;
import java.util.UUID;

import com.cicero.deliveryservices.domain.DeliveryOrder;
import com.cicero.deliveryservices.form.DeliveryOrderForm;

public interface DeliveryOrderService {
	DeliveryOrderForm findOrder(UUID order);
	List<DeliveryOrderForm> findAll();
	DeliveryOrderForm createOrUpdateOrder(DeliveryOrder order);
}
