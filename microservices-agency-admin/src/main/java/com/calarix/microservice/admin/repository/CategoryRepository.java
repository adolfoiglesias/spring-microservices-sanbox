/**
 * 
 */
package com.calarix.microservice.admin.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.calarix.microservices.commons.tour.Category;

/**
 * @author amich
 *
 */
@RepositoryRestResource(path = "categories")
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long>{

	public Category findByName(@Param("name") String name);
}
