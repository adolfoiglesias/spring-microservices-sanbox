/**
 * 
 */
package com.calarix.microservices.comment.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author amich
 *
 */
@Data
@AllArgsConstructor
public class Reservation {
	
	public Long id;
	
	public Tour tour;
	
	public Agency agency;
	
	public Long tourId;
	public Long agencyId;
	
	public String createAt;
	
	public String reservationDate;
	
	public double pax;
	
	public double price;
	
	public String email;
	
	@Override
	public String toString() {
		return String.format("Reservation %s - customer : %s - date : %s - tour : %s - price : %s", 
				id, email, reservationDate, tour.id + "(" + tour.name + ")", price );
	}
	
	
}
