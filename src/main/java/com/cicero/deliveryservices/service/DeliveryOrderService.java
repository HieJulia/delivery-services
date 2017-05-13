package com.cicero.deliveryservices.service;

import java.util.List;
import java.util.UUID;

import com.cicero.deliveryservices.domain.DeliveryOrder;

public interface DeliveryOrderService {
	DeliveryOrder findOrder(UUID order);
	List<DeliveryOrder> findAll();
	DeliveryOrder createOrUpdateOrder(DeliveryOrder order);
}
