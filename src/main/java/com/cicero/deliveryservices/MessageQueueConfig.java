package com.cicero.deliveryservices;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cicero.deliveryservices.receiver.DeliveryOrderReceiver;

/**
 * Configuracoes da fila
 * @author cicero
 *
 */
@Configuration
public class MessageQueueConfig {
    
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
	container.setPrefetchCount(1);
	return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(DeliveryOrderReceiver receiver) {
	return new MessageListenerAdapter(receiver, "receiveMessage");
    }
    
   @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setConcurrentConsumers(3);
        factory.setMaxConcurrentConsumers(10);
        return factory;
    }

}
