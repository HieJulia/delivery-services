package com.cicero.deliveryservices.sender;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cicero.deliveryservices.form.DeliveryOrderForm;

/**
 * Envia as ordem de entrega para fila.
 * @author cicero
 *
 */
@Component
public class MessageSender {

    private static final Logger log = LoggerFactory.getLogger(MessageSender.class);

    @Value("${delivery.service.queue}")
    private String queueName;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * Envia uma ordem de entrega para fila.
     * @param message mensagem a ser enviada para fila {@link DeliveryOrderForm}
     * @return {@link MessageResponse} resposta com identificador
     */
    @Scheduled(fixedDelay = 3000L)
    public MessageResponse sendMessage(DeliveryOrderForm message) {
	message.setOrderId(UUID.randomUUID());
	log.info("[Sending message] ==> " + message.toString());
	rabbitTemplate.convertAndSend(queueName, message);
	return new MessageResponse(message.getOrderId().toString());
    }

}
