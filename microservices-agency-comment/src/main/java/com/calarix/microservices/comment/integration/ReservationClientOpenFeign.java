/**
 * 
 */
package com.calarix.microservices.comment.integration;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.calarix.microservices.comment.model.Reservation;

/**
 * @author amich
 *
 */
@FeignClient(name="reservation-service")
public interface ReservationClientOpenFeign {
	
	@GetMapping
	public List<Reservation> findAllReservations();
	
	@GetMapping("{id}")
	public List<Reservation> findReservationById(Long id);
		

}
