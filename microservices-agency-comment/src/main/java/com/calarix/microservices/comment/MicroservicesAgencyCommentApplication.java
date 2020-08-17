package com.calarix.microservices.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.calarix.microservices.comment.integration.ReservationClientOpenFeign;
import com.calarix.microservices.comment.model.Comment;
import com.calarix.microservices.comment.model.CommentRepository;
import com.calarix.microservices.comment.model.Reservation;
import com.calarix.microservices.comment.model.ReservationID;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class MicroservicesAgencyCommentApplication implements CommandLineRunner {

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private ReservationClientOpenFeign reservationClientOpenFeign;
	
	public static void main(String[] args) {
		SpringApplication.run(MicroservicesAgencyCommentApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		initComment();
	}
	
	private void initComment() {
			
		List<Reservation> reservations = reservationClientOpenFeign.findAllReservations();
		
		if(!reservations.isEmpty() && commentRepository.count() == 0) {
			
			Comment comment = new Comment();
			comment.email = "user1@gmail.com";
			comment.reservation = reservations.get(0);
			comment.reservationID = new ReservationID();
			comment.reservationID.reservatioID = comment.reservation.id;
			comment.text = "Comment 1 some texts....";
			
			commentRepository.save(comment);
			
			comment = new Comment();
			comment.email = "user2@gmail.com";
			comment.reservation = reservations.get(0);
			comment.reservationID = new ReservationID();
			comment.reservationID.reservatioID = comment.reservation.id;
			comment.text = "COmment 2 some texts....";
			
			commentRepository.save(comment);
			
			comment = new Comment();
			comment.email = "user3@gmail.com";
			comment.reservation = reservations.get(0);
			comment.reservationID = new ReservationID();
			comment.reservationID.reservatioID = comment.reservation.id;
			comment.text = "COmment 3 some texts....";
			
			commentRepository.save(comment);
			
		} 
				
	}

}
