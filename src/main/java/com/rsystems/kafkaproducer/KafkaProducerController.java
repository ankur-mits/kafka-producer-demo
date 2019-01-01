package com.rsystems.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@GetMapping(value="/produce/{message}")
	public String sendMessage(@PathVariable String message) {
		kafkaTemplate.send("ten_topic", message);
		 return "Published Succefully";
	}
}
