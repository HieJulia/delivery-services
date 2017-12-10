package com.cicero.deliveryservices;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cicero.deliveryservices.receiver.DeliveryOrderReceiver;

/**
 * Queue Configurations
 * @author cicero
 *
 */
@Configuration
public class MessageQueueConfig {
    
    public static final String CACHE_QUEUE = "cache.router";
    
    public static final String PERSIST_QUEUE = "persist.router";

    private static final String deliveryServiceExchange = "fanoutroute";

    @Bean
    public Queue queueCache() {
	return new Queue(CACHE_QUEUE, false);
    }
    
    @Bean
    public Queue queuePersist() {
	return new Queue(PERSIST_QUEUE, false);
    }

    @Bean
    public FanoutExchange exchange() {
	return new FanoutExchange(deliveryServiceExchange);
    }

    @Bean
    public Binding bindingCacheQueue() {
	return BindingBuilder.bind(queueCache()).to(exchange());
    }
    
    @Bean
    public Binding bindingPersistQueue() {
	return BindingBuilder.bind(queuePersist()).to(exchange());
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
	    MessageListenerAdapter listenerAdapter) {
	SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
	container.setConnectionFactory(connectionFactory);
	container.setQueues(queueCache(), queuePersist());
	container.setMessageListener(listenerAdapter);
	return container;
    }
    
    @Bean
    public MessageListenerAdapter listenerAdapter(DeliveryOrderReceiver receiver) {
	return new MessageListenerAdapter(receiver, "receiveMessage");
    }
    
//   @Bean
//    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        factory.setConcurrentConsumers(3);
//        factory.setMaxConcurrentConsumers(10);
//        return factory;
//    }

}
