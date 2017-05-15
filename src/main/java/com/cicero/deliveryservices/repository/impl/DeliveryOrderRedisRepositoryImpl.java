package com.cicero.deliveryservices.repository.impl;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.cicero.deliveryservices.form.DeliveryOrderForm;
import com.cicero.deliveryservices.repository.DeliveryOrderRedisRepository;

@Component
public class DeliveryOrderRedisRepositoryImpl implements DeliveryOrderRedisRepository {
	
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

	@Override
	public void save(DeliveryOrderForm deliveryOrderForm) {
		hashOps.put(KEY, deliveryOrderForm.getOrderId().toString(), deliveryOrderForm);
	}

	@Override
	public DeliveryOrderForm findOne(String orderId) {
		return (DeliveryOrderForm) hashOps.get(KEY, orderId);
	}

	@Override
	public Map<String, DeliveryOrderForm> findAll() {
		return hashOps.entries(KEY);
	}

}
