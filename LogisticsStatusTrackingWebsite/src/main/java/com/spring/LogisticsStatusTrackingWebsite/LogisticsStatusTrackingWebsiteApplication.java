package com.spring.LogisticsStatusTrackingWebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication
public class LogisticsStatusTrackingWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticsStatusTrackingWebsiteApplication.class, args);
	}

}
