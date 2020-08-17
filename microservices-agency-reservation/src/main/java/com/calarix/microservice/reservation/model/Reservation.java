/**
 * 
 */
package com.calarix.microservice.reservation.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import com.calarix.microservices.commons.tour.Agency;
import com.calarix.microservices.commons.tour.Tour;

/**
 * @author amich
 *
 */
@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	
	@Transient
	public Tour tour;
	
	@Transient
	public Agency agency;
	
	public Long tourId;
	public Long agencyId;
	
	public LocalDateTime createAt;
	
	public LocalDate reservationDate;
	
	public double pax;
	
	public double price;
	
	@NotEmpty
	public String email;
	
	@Override
	public String toString() {
		return String.format("Reservation %s - customer : %s - date : %s - tour : %s - price : %s", 
				id, email, reservationDate.format(DateTimeFormatter.ISO_LOCAL_DATE), tour.id + "(" + tour.name + ")", price );
	}
	
}
