package com.cicero.deliveryservices.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cicero.deliveryservices.domain.DeliveryOrder;
import com.cicero.deliveryservices.repository.DeliveryOrderRepository;
import com.cicero.deliveryservices.service.DeliveryOrderService;
import com.google.common.collect.ImmutableList;

@Service
public class DeliveryOrderServiceImpl implements DeliveryOrderService {
	
	@Autowired
	private DeliveryOrderRepository deliveryOrderRepository;

	@Override
	public DeliveryOrder findOrder(UUID order) {
		return deliveryOrderRepository.findOne(order);
	}

	@Override
	public DeliveryOrder createOrUpdateOrder(DeliveryOrder order) {
		
		if (null == order.getOrderId()) {
			order.setOrderId(UUID.randomUUID());
		}
				
		return deliveryOrderRepository.save(order);
	}

	@Override
	public List<DeliveryOrder> findAll() {
		return ImmutableList.copyOf(deliveryOrderRepository.findAll());
	}

}
