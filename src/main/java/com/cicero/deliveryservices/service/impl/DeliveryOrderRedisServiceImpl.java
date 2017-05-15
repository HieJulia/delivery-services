package com.cicero.deliveryservices.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cicero.deliveryservices.form.DeliveryOrderForm;
import com.cicero.deliveryservices.repository.DeliveryOrderRedisRepository;
import com.cicero.deliveryservices.service.DeliveryOrderRedisService;

@Service
public class DeliveryOrderRedisServiceImpl implements DeliveryOrderRedisService {
	
	@Autowired
	private DeliveryOrderRedisRepository deliveryOrderRedisRepository;

	@Override
	public List<DeliveryOrderForm> findAll() {
		List<DeliveryOrderForm> deliverys = deliveryOrderRedisRepository.findAll().entrySet().stream()
                .map(delivery -> delivery.getValue())
                .collect(Collectors.toList());
		return deliverys;
	}

	@Override
	public DeliveryOrderForm findOne(String orderId) {
		return deliveryOrderRedisRepository.findOne(orderId);
	}
	
	public void save(DeliveryOrderForm deliveryOrderForm) {
		deliveryOrderRedisRepository.save(deliveryOrderForm);
	}

}
