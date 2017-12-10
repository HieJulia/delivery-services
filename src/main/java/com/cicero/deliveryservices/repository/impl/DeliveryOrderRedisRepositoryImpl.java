package com.cicero.deliveryservices.repository.impl;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.cicero.deliveryservices.form.DeliveryOrderForm;
import com.cicero.deliveryservices.repository.DeliveryOrderRedisRepository;
import com.cicero.deliveryservices.sender.MessageSender;

/**
 * Implementacao do repositorio para as operacoes no Redis.
 * @author cicero
 *
 */
@Component
public class DeliveryOrderRedisRepositoryImpl implements DeliveryOrderRedisRepository {
    
    
    private static final Logger log = LoggerFactory.getLogger(DeliveryOrderRedisRepositoryImpl.class);

    /**
     * Chave no Redis.
     */
    private static final String KEY = "DeliveryOrder";

    private RedisTemplate redisTemplate;
    private HashOperations hashOps;

    @Autowired
    private DeliveryOrderRedisRepositoryImpl(RedisTemplate redisTemplate) {
	this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
	hashOps = redisTemplate.opsForHash();
    }

    /* (non-Javadoc)
     * @see com.cicero.deliveryservices.repository.DeliveryOrderRedisRepository#save(com.cicero.deliveryservices.form.DeliveryOrderForm)
     */
    @Override
    public void save(DeliveryOrderForm deliveryOrderForm) {
	log.info("DeliveryOrderRedisRepositoryImpl M=save", deliveryOrderForm.toString());
	hashOps.put(KEY, deliveryOrderForm.getOrderId().toString(), deliveryOrderForm);
	log.info("DeliveryOrderRedisRepositoryImpl M=save fim", deliveryOrderForm.toString());
    }

    /* (non-Javadoc)
     * @see com.cicero.deliveryservices.repository.DeliveryOrderRedisRepository#findOne(java.lang.String)
     */
    @Override
    public DeliveryOrderForm findOne(String orderId) {
	return (DeliveryOrderForm) hashOps.get(KEY, orderId);
    }

    /* (non-Javadoc)
     * @see com.cicero.deliveryservices.repository.DeliveryOrderRedisRepository#findAll()
     */
    @Override
    public Map<String, DeliveryOrderForm> findAll() {
	return hashOps.entries(KEY);
    }

}
