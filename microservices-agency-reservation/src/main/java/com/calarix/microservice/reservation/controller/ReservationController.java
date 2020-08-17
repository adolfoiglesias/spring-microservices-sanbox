/**
 * 
 */
package com.calarix.microservice.reservation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.calarix.microservice.reservation.model.Reservation;
import com.calarix.microservice.reservation.service.ReservationService;

/**
 * @author amich
 *
 */
@RestController
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public ResponseEntity<List<Reservation>> list() {
		return ResponseEntity.ok(reservationService.list());
	}
	
	@PostMapping
	public ResponseEntity save(@RequestBody @Valid Reservation reservation) {
		/*
		 * if(bindException.hasErrors()) { List<ObjectError> errors =
		 * bindException.getBindingResult().getAllErrors(); return
		 * ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.get(0)); }
		 */
		reservationService.save(reservation);
		return ResponseEntity.status(HttpStatus.CREATED).body(reservation);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Reservation> findById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(reservationService.findById(id));
	}

}
