package com.cicero.deliveryservices.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cicero.deliveryservices.domain.DeliveryOrder;

@Component
public class MessageSender {

	private static final Logger log = LoggerFactory.getLogger(MessageSender.class);
	
	final static String queueName = "delivery-service";

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Scheduled(fixedDelay = 3000L)
	public void sendMessage(DeliveryOrder message) {
		log.info("Sending message...");
		rabbitTemplate.convertAndSend(queueName, message);
	}

}
