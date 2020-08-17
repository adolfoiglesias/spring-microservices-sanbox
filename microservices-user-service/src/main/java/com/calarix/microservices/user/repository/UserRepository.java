package com.calarix.microservices.user.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path="usuarios")
public interface UserRepository extends PagingAndSortingRepository<com.calarix.microservices.commons.user.User, Long>{

	@RestResource(path="buscar-username")
	public com.calarix.microservices.commons.user.User findByUsername(@Param("username") String username);
	
	@Query("select u from com.calarix.microservices.commons.user.User u where u.username=?1")
	public com.calarix.microservices.commons.user.User obtenerPorUsername(String username);
}
