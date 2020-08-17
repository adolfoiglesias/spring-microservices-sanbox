/**
 * 
 */
package com.calarix.microservice.reservation.service;

import java.util.List;

import com.calarix.microservice.reservation.model.Reservation;

/**
 * @author amich
 *
 */
public interface ReservationService {

	public List<Reservation> list();
	
	public void save(Reservation reservation);
	
	public Reservation findById(Long id);
}
