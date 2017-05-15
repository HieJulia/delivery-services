package com.cicero.deliveryservices.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cicero.deliveryservices.domain.DeliveryOrder;
import com.cicero.deliveryservices.form.DeliveryOrderForm;
import com.cicero.deliveryservices.repository.DeliveryOrderRepository;
import com.cicero.deliveryservices.service.DeliveryOrderRedisService;
import com.cicero.deliveryservices.service.DeliveryOrderService;
import com.cicero.deliveryservices.util.OrderServiceConverter;

@Service
public class DeliveryOrderServiceImpl implements DeliveryOrderService {
	
	@Autowired
	private DeliveryOrderRepository deliveryOrderRepository;
	
	@Autowired
	private DeliveryOrderRedisService deliveryOrderRedisService;

	@Override
	public DeliveryOrderForm findOrder(UUID order) {
		DeliveryOrderForm found = deliveryOrderRedisService.findOne(order.toString());
		if (null == found) {
			found = OrderServiceConverter.convertFromDeliveryOrder(deliveryOrderRepository.findOne(order));
			deliveryOrderRedisService.save(found);
		}
		
		return found;
	}

	@Override
	public DeliveryOrderForm createOrUpdateOrder(final DeliveryOrder order) {
		if (null == order.getOrderId()) {
			order.setOrderId(UUID.randomUUID());
		}
				
		return OrderServiceConverter.convertFromDeliveryOrder(deliveryOrderRepository.save(order));
	}

	@Override
	public List<DeliveryOrderForm> findAll() {
		List<DeliveryOrderForm> deliverys = deliveryOrderRedisService.findAll();
		
		for (DeliveryOrderForm delivery : deliveryOrderRedisService.findAll()) {
			deliverys.add(delivery);
		}
		
		return deliverys;
	}

}
