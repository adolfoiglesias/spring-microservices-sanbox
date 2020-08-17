/**
 * 
 */
package com.calarix.microservice.admin.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.calarix.microservices.commons.tour.Tour;

/**
 * @author amich
 *
 */
@RepositoryRestResource(path = "tours")
public interface TourRepository extends PagingAndSortingRepository<Tour, Long>{

}
