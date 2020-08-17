/**
 * 
 */
package com.calarix.microservice.reservation;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.calarix.microservice.reservation.model.Reservation;

/**
 * @author amich
 *
 */
public interface ReservationRepository extends PagingAndSortingRepository<Reservation,Long>{
	

}
