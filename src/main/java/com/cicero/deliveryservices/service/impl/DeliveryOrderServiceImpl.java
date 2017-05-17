package com.cicero.deliveryservices.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cicero.deliveryservices.domain.DeliveryOrder;
import com.cicero.deliveryservices.form.DeliveryOrderForm;
import com.cicero.deliveryservices.repository.DeliveryOrderRepository;
import com.cicero.deliveryservices.service.DeliveryOrderCacheService;
import com.cicero.deliveryservices.service.DeliveryOrderService;
import com.cicero.deliveryservices.util.OrderServiceConverter;

/**
 * Implementacao de {@link DeliveryOrderService}
 * @author cicero
 *
 */
@Service
public class DeliveryOrderServiceImpl implements DeliveryOrderService {

    @Autowired
    private DeliveryOrderRepository deliveryOrderRepository;

    @Autowired
    private DeliveryOrderCacheService deliveryOrderCacheService;

    /* (non-Javadoc)
     * @see com.cicero.deliveryservices.service.DeliveryOrderService#findOrder(java.util.UUID)
     */
    @Override
    public DeliveryOrderForm findOrder(UUID order) {
	DeliveryOrderForm found = deliveryOrderCacheService.findOne(order.toString());
	if (null == found) {
	    found = OrderServiceConverter.convertFromDeliveryOrder(deliveryOrderRepository.findOne(order));
	    deliveryOrderCacheService.save(found);
	}

	return found;
    }

    /* (non-Javadoc)
     * @see com.cicero.deliveryservices.service.DeliveryOrderService#createOrUpdateOrder(com.cicero.deliveryservices.domain.DeliveryOrder)
     */
    @Override
    public DeliveryOrderForm createOrUpdateOrder(final DeliveryOrder order) {
	if (null == order.getOrderId()) {
	    order.setOrderId(UUID.randomUUID());
	}

	return OrderServiceConverter.convertFromDeliveryOrder(deliveryOrderRepository.save(order));
    }

    /* (non-Javadoc)
     * @see com.cicero.deliveryservices.service.DeliveryOrderService#findAll()
     */
    @Override
    public List<DeliveryOrderForm> findAll() {
	List<DeliveryOrderForm> deliverys = deliveryOrderCacheService.findAll();
	
	if (null == deliverys || deliverys.isEmpty()) {
	    
	    for (DeliveryOrder deliveryOrder : this.deliveryOrderRepository.findAll()) {
		DeliveryOrderForm found = OrderServiceConverter.convertFromDeliveryOrder(deliveryOrder);
		deliveryOrderCacheService.save(found);
		deliverys.add(found);
	    }
	}

	return deliverys;
    }

}
