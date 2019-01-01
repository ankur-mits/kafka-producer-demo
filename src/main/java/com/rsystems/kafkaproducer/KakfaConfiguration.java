package com.rsystems.kafkaproducer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;


@Configuration
public class KakfaConfiguration {
	@Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
		
		return new KafkaTemplate<>(producerFactory());
	}

	private ProducerFactory<String, String> producerFactory() {
		Map config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.67.171.30:9092");
		//config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "203.34.117.152:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		
        return new DefaultKafkaProducerFactory<String, String>(config);

		
	}
}
