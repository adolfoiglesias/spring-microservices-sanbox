/**
 * 
 */
package com.calarix.microservices.comment.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author amich
 *
 */
@Data
@Component
public class KafkaProperties {

	/*
	 * @Value("${kafka.topic}") String kafkaTopic;
	 */
	
	@Value("${spring.kafka.consumer.bootstrap-servers}")
	String kafkaBootstrapServers;
	
	@Value("${kafka.consumer.concurrent.worker.count}")
	int messageConsumerConcurrentWorkerCount;

	@Value("${kafka.poll.timeout.millis}")
	int messagePollTimeoutInMillis;
	
	@Value("${spring.kafka.consumer.group-id}")
	String consumerGroupId;

}
