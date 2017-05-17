package com.cicero.deliveryservices;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Configuracoes do cache
 * @author cicero
 *
 */
@Configuration
public class CacheConfig {
    
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

}
