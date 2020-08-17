/**
 * 
 */
package com.calarix.microservice.reservation.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.calarix.microservice.reservation.model.Reservation;
import com.fasterxml.jackson.core.JsonProcessingException;
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
public class MessageServiceKafka implements MessageService {


	private static final Logger logger = LoggerFactory.getLogger(MessageServiceKafka.class);
	private static final String TOPIC = "reservations";
	
	@Autowired
	private ObjectMapper  objectMapper;

	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Override
	public void sendEmail(Reservation reservation) throws JsonProcessingException {
		
		logger.info("Producer message -> " + reservation.toString());
		
		Map<String, Object> map = new HashMap<>();
		map.put("id", reservation.id);
		map.put("email", reservation.email);
		map.put("tour", reservation.tour.id);
		
		
		//String emailStr = objectMapper.writeValueAsString(reservation);
		String mapRx = objectMapper.writeValueAsString(map);
		this.kafkaTemplate.send(TOPIC,mapRx);
	}
}
