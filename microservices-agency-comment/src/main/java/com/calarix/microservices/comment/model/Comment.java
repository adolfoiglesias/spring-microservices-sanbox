/**
 * 
 */
package com.calarix.microservices.comment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * @author amich
 *
 */
@Data
@Document(collection = "comments")
public class Comment {
	
	@Id
	public String id;
	public String email;
	public String text;
	
	public ReservationID reservationID;
	
	@Transient
	public Reservation reservation;

}
