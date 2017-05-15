package com.cicero.deliveryservices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cicero.deliveryservices.form.DeliveryOrderForm;
import com.cicero.deliveryservices.service.DeliveryOrderRedisService;
import com.cicero.deliveryservices.service.DeliveryOrderService;
import com.cicero.deliveryservices.service.DeliveryService;

@Service
public class DeliveryServiceImpl implements DeliveryService {
	
	@Autowired
	private DeliveryOrderRedisService deliveryOrderRedisService;
	
	@Autowired
	private DeliveryOrderService deliveryOrderService;

	@Override
	public List<DeliveryOrderForm> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeliveryOrderForm findOne(String orderId) {
		deliveryOrderRedisService.findOne(orderId);
		return null;
	}

}
