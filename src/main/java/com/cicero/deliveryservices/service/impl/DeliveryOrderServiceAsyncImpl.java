package com.cicero.deliveryservices.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cicero.deliveryservices.domain.DeliveryOrder;
import com.cicero.deliveryservices.sender.MessageSender;
import com.cicero.deliveryservices.service.DeliveryOrderServiceAsync;

@Service
public class DeliveryOrderServiceAsyncImpl implements DeliveryOrderServiceAsync {
	
	@Autowired
	private MessageSender sender;

	@Override
 	public DeliveryOrder createOrUpdateOrder(DeliveryOrder order) {
		// TODO - RETORNAR UUIDD EM UM OBJETO
		this.sender.sendMessage(order);
		return order;
	}

}
