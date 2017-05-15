package com.cicero.deliveryservices.service;

import java.util.List;

import com.cicero.deliveryservices.form.DeliveryOrderForm;

public interface DeliveryService {
	List<DeliveryOrderForm> findAll();
	DeliveryOrderForm findOne(String orderId);
}
