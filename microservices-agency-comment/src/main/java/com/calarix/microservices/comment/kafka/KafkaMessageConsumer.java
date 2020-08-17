/**
 * 
 */
package com.calarix.microservices.comment.kafka;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.calarix.microservices.comment.model.Reservation;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author amich
 *
 */
/*
https://dzone.com/articles/magic-of-kafka-with-spring-boot
https://github.com/privatevkakarla1985/project8-vkakarla-springboot-kafka-producer-consumer-service/blob/master/src/main/java/com/vrktech/springboot/kafka/controller/HelloController.java
*/

@Service
public class KafkaMessageConsumer {

	private final Logger logger = LoggerFactory.getLogger(KafkaMessageConsumer.class);
	@Autowired
	KafkaProperties kafkaProperties;
	
	@Autowired
	private ObjectMapper objectMapper; 

	@KafkaListener(topics = "reservations", groupId = "group-id")
	public void consume(String message) {
		
		logger.info("Consume message from Kafka ");
		
		//Map mapRx = objectMapper.convertValue(message, HashMap.class);
		 
		logger.info("Reservation read from Kafka " + message);
	}

}
