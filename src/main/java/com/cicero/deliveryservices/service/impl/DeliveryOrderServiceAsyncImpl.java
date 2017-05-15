package com.cicero.deliveryservices.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cicero.deliveryservices.form.DeliveryOrderForm;
import com.cicero.deliveryservices.sender.MessageResponse;
import com.cicero.deliveryservices.sender.MessageSender;
import com.cicero.deliveryservices.service.DeliveryOrderServiceAsync;

/**
 * Implementacao de {@link DeliveryOrderServiceAsync}
 * @author cicero
 *
 */
@Service
public class DeliveryOrderServiceAsyncImpl implements DeliveryOrderServiceAsync {

    @Autowired
    private MessageSender sender;

    /* (non-Javadoc)
     * @see com.cicero.deliveryservices.service.DeliveryOrderServiceAsync#createOrUpdateOrder(com.cicero.deliveryservices.form.DeliveryOrderForm)
     */
    @Override
    public MessageResponse createOrUpdateOrder(final DeliveryOrderForm order) {
	return this.sender.sendMessage(order);
    }

}
