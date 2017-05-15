package com.cicero.deliveryservices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cicero.deliveryservices.form.DeliveryOrderForm;
import com.cicero.deliveryservices.service.DeliveryOrderRedisService;
import com.cicero.deliveryservices.service.DeliveryOrderService;
import com.cicero.deliveryservices.service.DeliveryService;

/**
 * Implementacao de {@linkDeliveryService}
 * @author cicero
 *
 */
@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryOrderRedisService deliveryOrderRedisService;

    @Autowired
    private DeliveryOrderService deliveryOrderService;

    /* (non-Javadoc)
     * @see com.cicero.deliveryservices.service.DeliveryService#findAll()
     */
    @Override
    public List<DeliveryOrderForm> findAll() {
	return deliveryOrderRedisService.findAll();
    }

    /* (non-Javadoc)
     * @see com.cicero.deliveryservices.service.DeliveryService#findOne(java.lang.String)
     */
    @Override
    public DeliveryOrderForm findOne(String orderId) {
	deliveryOrderRedisService.findOne(orderId);
	return null;
    }

}
