package com.cicero.deliveryservices;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.cicero.deliveryservices.receiver.DeliveryOrderReceiver;

@SpringBootApplication
public class DeliveryServicesApplication {

    @Value("${delivery.service.queue}")
    private String queueName;

    @Value("${delivery.service.exchange}")
    private String deliveryServiceExchange;

    @Bean
    Queue queue() {
	return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
	return new TopicExchange(deliveryServiceExchange);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
	return BindingBuilder.bind(queue).to(exchange).with(queueName);
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
	    MessageListenerAdapter listenerAdapter) {
	SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
	container.setConnectionFactory(connectionFactory);
	container.setQueueNames(queueName);
	container.setMessageListener(listenerAdapter);
	container.setPrefetchCount(2);
	return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(DeliveryOrderReceiver receiver) {
	return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
	return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
	RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
	template.setConnectionFactory(jedisConnectionFactory());
	return template;
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
	RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
	cacheManager.setDefaultExpiration(3000);
	return cacheManager;
    }

    public static void main(String[] args) {
	SpringApplication.run(DeliveryServicesApplication.class, args);
    }
}
