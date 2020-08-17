/**
 * 
 */
package com.calarix.microservice.reservation.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.calarix.microservices.commons.tour.Tour;

/**
 * @author amich
 *
 */
@FeignClient(name="admin-service")
public interface TourClientServiceFeign {
	
	@GetMapping("tours/{id}")
	public Tour findById(@PathVariable Long id);
	
}
