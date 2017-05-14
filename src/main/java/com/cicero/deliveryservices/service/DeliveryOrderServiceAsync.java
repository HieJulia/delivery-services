package com.cicero.deliveryservices.service;

import com.cicero.deliveryservices.domain.DeliveryOrder;

public interface DeliveryOrderServiceAsync {
	DeliveryOrder createOrUpdateOrder(DeliveryOrder order);
}
