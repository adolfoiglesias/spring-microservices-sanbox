/**
 * 
 */
package com.calarix.microservice.reservation.service;

import com.calarix.microservice.reservation.model.Reservation;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author amich
 *
 */
public interface MessageService {
	
	public void sendEmail(Reservation reservation) throws JsonProcessingException;

}
