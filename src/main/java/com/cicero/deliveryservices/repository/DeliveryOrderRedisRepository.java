package com.cicero.deliveryservices.repository;

import java.util.Map;

import com.cicero.deliveryservices.form.DeliveryOrderForm;

public interface DeliveryOrderRedisRepository {
	void save(DeliveryOrderForm deliveryOrderForm);
	Map<String, DeliveryOrderForm> findAll();
	DeliveryOrderForm findOne(String orderId);
}
