package com.calarix.microservice.admin.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.calarix.microservices.commons.tour.Agency;


@RepositoryRestResource(path="agencies")
public interface AgencyRepository extends PagingAndSortingRepository<Agency, Long> {
	
	

}
