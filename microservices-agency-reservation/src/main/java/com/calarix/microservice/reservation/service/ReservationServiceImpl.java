/**
 * 
 */
package com.calarix.microservice.reservation.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calarix.microservice.reservation.ReservationRepository;
import com.calarix.microservice.reservation.integration.TourClientServiceFeign;
import com.calarix.microservice.reservation.model.Reservation;
import com.calarix.microservices.commons.tour.Tour;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author amich
 *
 */
@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private ReservationRepository  reservationRepository;    
	
	@Autowired
	private TourClientServiceFeign tourClient;
	
	@Autowired
	private MessageService messageService; 
	
	@Override
	public List<Reservation> list() {
		// obtener toos los datos del tour
		List<Reservation> list = (List)reservationRepository.findAll();
		list.forEach(rx  -> {
			rx.tour = tourClient.findById(rx.tourId);
		});
		return list;
	}
	
	@Override
	public void save(Reservation reservation) {
		// verificar que exista el tour 
		Tour tour = tourClient.findById(reservation.tour.id);
		if(tour == null) {
			// throw;;;
		}		
		reservation.tourId = reservation.tour.id;
		reservation.createAt = LocalDateTime.now();
		reservationRepository.save(reservation);
		
		try {
			messageService.sendEmail(reservation);
		
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public Reservation findById(Long id) {
		return reservationRepository.findById(id).orElse(null);
	}
}
