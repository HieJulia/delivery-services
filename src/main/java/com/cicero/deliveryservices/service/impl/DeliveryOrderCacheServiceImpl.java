package com.cicero.deliveryservices.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cicero.deliveryservices.form.DeliveryOrderForm;
import com.cicero.deliveryservices.repository.DeliveryOrderRedisRepository;
import com.cicero.deliveryservices.service.DeliveryOrderCacheService;

/**
 * Implementacao de {@link DeliveryOrderCacheService}
 * @author cicero
 *
 */
@Service
public class DeliveryOrderCacheServiceImpl implements DeliveryOrderCacheService {

    @Autowired
    private DeliveryOrderRedisRepository deliveryOrderCacheRepository;

    /* (non-Javadoc)
     * @see com.cicero.deliveryservices.service.DeliveryOrderRedisService#findAll()
     */
    @Override
    public List<DeliveryOrderForm> findAll() {
	List<DeliveryOrderForm> deliverys = deliveryOrderCacheRepository.findAll().entrySet().stream()
		.map(delivery -> delivery.getValue()).collect(Collectors.toList());
	return deliverys;
    }

    /* (non-Javadoc)
     * @see com.cicero.deliveryservices.service.DeliveryOrderRedisService#findOne(java.lang.String)
     */
    @Override
    public DeliveryOrderForm findOne(String orderId) {
	return deliveryOrderCacheRepository.findOne(orderId);
    }

    /* (non-Javadoc)
     * @see com.cicero.deliveryservices.service.DeliveryOrderRedisService#save(com.cicero.deliveryservices.form.DeliveryOrderForm)
     */
    public void save(DeliveryOrderForm deliveryOrderForm) {
	deliveryOrderCacheRepository.save(deliveryOrderForm);
    }

}
