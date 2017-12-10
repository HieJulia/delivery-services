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

    @Value("${delivery.service.exchange}")
    private String deliveryServiceExchange;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * Envia uma ordem de entrega para o exchange.
     * @param message mensagem a ser enviada para fila {@link DeliveryOrderForm}
     * @return {@link MessageResponse} resposta com identificador
     */
    public MessageResponse sendMessage(DeliveryOrderForm message) {
	message.setOrderId(UUID.randomUUID());
	log.info("[Sending message] ==> " + message.toString());
	rabbitTemplate.convertAndSend("fanoutroute", "", message);
	return new MessageResponse(message.getOrderId().toString());
    }

}
