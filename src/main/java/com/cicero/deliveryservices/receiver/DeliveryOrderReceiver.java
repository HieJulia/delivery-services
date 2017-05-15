package com.cicero.deliveryservices.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cicero.deliveryservices.form.DeliveryOrderForm;
import com.cicero.deliveryservices.sender.MessageSender;
import com.cicero.deliveryservices.service.DeliveryOrderService;
import com.cicero.deliveryservices.util.OrderServiceConverter;

/**
 * Consumer para salvar a mensagem do banco de dados.
 * 
 * @author cicero
 *
 */
@Component
public class DeliveryOrderReceiver {

    private static final Logger log = LoggerFactory.getLogger(MessageSender.class);

    @Autowired
    private DeliveryOrderService deliveryOrderService;

    /**
     * Recebe a mensagem da fila e persiste no banco
     * 
     * @param orderMessage
     *            uma ordem de entrega.
     */
    public void receiveMessage(DeliveryOrderForm orderMessage) {
	log.info("[Received Message]:: " + orderMessage);
	this.deliveryOrderService.createOrUpdateOrder(OrderServiceConverter.convertFromDeliveryForm(orderMessage));
    }

}
