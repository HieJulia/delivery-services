package com.cicero.deliveryservices.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cicero.deliveryservices.form.DeliveryOrderForm;
import com.cicero.deliveryservices.repository.DeliveryOrderRedisRepository;
import com.cicero.deliveryservices.sender.MessageSender;

@Component
public class DeliveryOrderReceiverCache {
	
	private static final Logger log = LoggerFactory.getLogger(MessageSender.class);
	
	
	@Autowired
	private DeliveryOrderRedisRepository deliveryOrderRedisRepository;

	@RabbitListener(queues = "delivery-service")
	public void receiveMessage(DeliveryOrderForm orderMessage) {
		log.info("[Received Message-Redis]:: " + orderMessage);
		this.deliveryOrderRedisRepository.save(orderMessage);
	}

}
