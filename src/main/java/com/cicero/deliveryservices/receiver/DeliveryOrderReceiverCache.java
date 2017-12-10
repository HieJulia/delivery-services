package com.cicero.deliveryservices.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.cicero.deliveryservices.MessageQueueConfig;
import com.cicero.deliveryservices.form.DeliveryOrderForm;
import com.cicero.deliveryservices.repository.DeliveryOrderRedisRepository;
import com.cicero.deliveryservices.sender.MessageSender;

/**
 * Consumer para salvar mensagem no Redis
 * 
 * @author cicero
 *
 */
@Component
public class DeliveryOrderReceiverCache {

    private static final Logger log = LoggerFactory.getLogger(MessageSender.class);

    @Autowired
    private DeliveryOrderRedisRepository deliveryOrderRedisRepository;

    /**
     * Salva a mensagem da fila no Redis
     * 
     * @param orderMessage
     *            uma ordem de entrega.
     */
    @RabbitListener(queues = "cache.router")
    public void receiveMessage(DeliveryOrderForm orderMessage) {
	log.info("[Received Message][Cache]:: " + orderMessage);
	this.deliveryOrderRedisRepository.save(orderMessage);
    }

}
